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
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val authenticationUseCase: AuthenticationUseCase
) : ViewModel() {

    private val _viewState = MutableStateFlow<SignInViewState>(SignInViewState.HideLoading)
    val viewState: StateFlow<SignInViewState> = _viewState.asStateFlow()

    fun process(event: SignInEvent) {
        when (event) {
            is SignInEvent.DoLogin -> doLogin(event.userName, event.password)
        }
    }

    private fun doLogin(username: String, password: String) {
        viewModelScope.launch {
            _viewState.value = SignInViewState.ShowLoading

            authenticationUseCase(username, password)
                .collect { authentication ->
                    when (authentication) {
                        AuthenticationResult.Authorization -> {
                            _viewState.value = SignInViewState.Authorization
                        }
                        is AuthenticationResult.Denied -> {
                            _viewState.value = SignInViewState.Error(authentication.message)
                        }
                        AuthenticationResult.AnotherError -> {
                            _viewState.value = SignInViewState.AnotherError
                        }
                    }
                }

            _viewState.value = SignInViewState.HideLoading
        }
    }
}