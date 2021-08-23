package com.smparkworld.daangnmarket.ui.launch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.smparkworld.daangnmarket.DaangnApp
import com.smparkworld.daangnmarket.R
import com.smparkworld.daangnmarket.ui.launch.di.LoginComponent

class LoginActivity : AppCompatActivity() {

    lateinit var loginComponent: LoginComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        loginComponent = (application as DaangnApp).appComponent.loginComponent().create()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch_login)

        supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, AddressFragment())
                .commitNow()
    }

    fun nextStep() {
        android.R.anim.slide_in_left
        supportFragmentManager.beginTransaction()
                .setCustomAnimations(
                        R.anim.translate_launch_swipe_next_enter,
                        R.anim.translate_launch_swipe_next_exit,
                        R.anim.translate_launch_swipe_back_enter,
                        R.anim.translate_launch_swipe_back_exit,
                )
                .replace(R.id.fragmentContainer, AuthFragment())
                .addToBackStack(null)
                .commit()
    }
}