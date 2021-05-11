package com.mmaquera.netgame.view.login.signin

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.boris.netgame.usecases.AuthenticationUseCase
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(private val authenticationUseCase: AuthenticationUseCase) :
    ViewModel() {

    fun authorization(username: String, password: String) {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                authenticationUseCase(username, password)
            }

            Log.i("netgame", Gson().toJson(result))
        }
    }
}