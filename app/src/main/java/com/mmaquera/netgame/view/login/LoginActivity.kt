package com.mmaquera.netgame.view.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mmaquera.netgame.R
import com.mmaquera.netgame.application.AppApplication
import com.mmaquera.netgame.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    //lateinit var loginComponent: LoginComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme_NoActionBar)
        //loginComponent = (application as AppApplication).appComponent.loginComponent().create()
        //loginComponent.inject(this)
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
