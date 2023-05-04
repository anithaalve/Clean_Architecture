package com.example.cleanarchitectureusingmvvm.screens.login

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.cleanarchitectureusingmvvm.base.BaseUTTest
import com.example.cleanarchitectureusingmvvm.di.configureTestAppComponent
import com.example.cleanarchitectureusingmvvm.models.login.AllPeople
import com.example.cleanarchitectureusingmvvm.platform.LiveDataWrapper
import com.google.gson.Gson
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.koin.core.context.startKoin

/**
 * Created by aalvekod on 29-03-2023.
 * LoginActivityViewModel testing.
 */
@RunWith(JUnit4::class)
class LoginActivityViewModelTest: BaseUTTest(){

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    lateinit var mLoginActivityViewModel: LoginActivityViewModel

    val mDispatcher = Dispatchers.Unconfined

    @MockK
    lateinit var mLoginUseCase: LoginUseCase

    val mParam = "1"
    val mNextValue = "https://swapi.co/api/people/?page=2"

    @Before
    fun start(){
        super.setUp()
        //Used for initiation of Mockk
        MockKAnnotations.init(this)
        //Start Koin with required dependencies
        startKoin{ modules(configureTestAppComponent(getMockWebServerUrl()))}
    }

    @Test
    fun testDataPopulatesExpectedValue(){

        mLoginActivityViewModel = LoginActivityViewModel(mDispatcher,mDispatcher,mLoginUseCase)
        val sampleResponse = getJson("user_list.json")
        var jsonObj = Gson().fromJson(sampleResponse, AllPeople::class.java)
        //Make sure login use case returns expected response when called
        coEvery { mLoginUseCase.processLoginUseCase(any()) } returns jsonObj
        mLoginActivityViewModel.mAllPeopleResponse.observeForever {  }

        mLoginActivityViewModel.requestLoginActivityData(mParam)

        assert(mLoginActivityViewModel.mAllPeopleResponse.value != null)
        assert(
            mLoginActivityViewModel.mAllPeopleResponse.value!!.responseStatus
                == LiveDataWrapper.RESPONSESTATUS.SUCCESS)
        val testResult = mLoginActivityViewModel.mAllPeopleResponse.value as LiveDataWrapper<AllPeople>
        assertEquals(testResult.response!!.next,mNextValue)
    }
}