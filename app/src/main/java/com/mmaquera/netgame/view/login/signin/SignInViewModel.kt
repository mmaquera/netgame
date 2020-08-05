package com.mmaquera.netgame.view.login.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class SignInViewModel @Inject constructor() : ViewModel() {


    fun authorization(username: String, password: String) {
        viewModelScope.launch {

        }
    }
}