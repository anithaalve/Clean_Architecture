package com.example.cleanarchitectureusingmvvm.screens.login

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.cleanarchitectureusingmvvm.base.BaseUTTest
import com.example.cleanarchitectureusingmvvm.di.configureTestAppComponent
import com.example.cleanarchitectureusingmvvm.models.login.AllPeople
import com.example.cleanarchitectureusingmvvm.network.login.LoginAPIService
import com.example.cleanarchitectureusingmvvm.repository.LoginRepository
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.koin.core.context.startKoin
import org.koin.test.inject
import java.net.HttpURLConnection

/**
 * Created by aalvekod on 29-03-2023.
 *
 */
@RunWith(JUnit4::class)
class LoginUseCaseTest : BaseUTTest(){

    //Target
    private lateinit var mLoginUseCase: LoginUseCase

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    val mNextValue = "https://swapi.co/api/people/?page=2"
    val mParam = "1"
    val mCount = 87

    @Before
    fun start(){
        super.setUp()
        //Start Koin with required dependencies
        startKoin{ modules(configureTestAppComponent(getMockWebServerUrl()))}
    }

    @Test
    fun testLoginUseCaseReturnsExpectedValue()= runBlocking{

        mockNetworkResponseWithFileContent("user_list.json", HttpURLConnection.HTTP_OK)
        mLoginUseCase = LoginUseCase()

        val dataReceived = mLoginUseCase.processLoginUseCase(mParam)

        assertNotNull(dataReceived)
        assertEquals(dataReceived.count, mCount)
        assertEquals(dataReceived.next, mNextValue)
    }
}