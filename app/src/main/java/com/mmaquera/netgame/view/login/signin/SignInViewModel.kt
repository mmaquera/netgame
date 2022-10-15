package com.mmaquera.netgame.view.login.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.boris.netgame.domain.result.AuthenticationResult
import com.boris.netgame.usecases.AuthenticationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val authenticationUseCase: AuthenticationUseCase
) :
    ViewModel() {

    private val _viewState = MutableStateFlow<SignInViewState>(SignInViewState.HideLoading)
    val viewState: StateFlow<SignInViewState> = _viewState

    fun process(event: SignInEvent) {
        when (event) {
            is SignInEvent.DoLogin -> doLogin(event.userName, event.password)
        }
    }

    private fun doLogin(username: String, password: String) {
        viewModelScope.launch {
            _viewState.value = SignInViewState.ShowLoading

            val result = withContext(Dispatchers.IO) {
                authenticationUseCase(username, password)
            }

            when (result) {
                AuthenticationResult.AnotherError -> _viewState.value = SignInViewState.AnotherError
                AuthenticationResult.Authorization -> _viewState.value =
                    SignInViewState.Authorization
                is AuthenticationResult.Denied -> _viewState.value =
                    SignInViewState.Error(result.message)
            }

            _viewState.value = SignInViewState.HideLoading
        }
    }
}