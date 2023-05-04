package com.example.cleanarchitectureusingmvvm.screens.login

import android.os.Bundle
import com.example.cleanarchitectureusingmvvm.R
import com.example.cleanarchitectureusingmvvm.platform.BaseActivity

/**
 * Activity holder for Login Flow.
 */
class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configureAndShowFragment()
    }

    private fun configureAndShowFragment() {
        val fragment = supportFragmentManager.findFragmentById(R.id.base_frame_layout) as LoginActivityFragment?
        if(fragment == null){
            supportFragmentManager.beginTransaction()
                .add(R.id.base_frame_layout, LoginActivityFragment.getMainActivityFragment())
                .commit()
        }
    }
}
