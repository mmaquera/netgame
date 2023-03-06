package com.mmaquera.netgame.view.login.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.boris.netgame.domain.result.SignUpResult
import com.boris.netgame.usecases.SignUpUseCase
import com.mmaquera.netgame.view.login.signin.SignInViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase
) : ViewModel() {

    private val _viewState = MutableStateFlow<SignUpViewState>(SignUpViewState.HideLoading)
    val viewState: StateFlow<SignUpViewState> = _viewState

    fun process(viewEvent: SignUpViewEvent) {
        _viewState.value = SignUpViewState.ShowLoading
        when (viewEvent) {
            is SignUpViewEvent.DoSignUp -> signUp(
                viewEvent.userName,
                viewEvent.password,
                viewEvent.confirmPassword
            )
        }
    }

    private fun signUp(userName: String, password: String, confirmPassword: String) {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO){
                signUpUseCase(userName, password)
            }

            when(result){
                is SignUpResult.SignUpError -> _viewState.value = SignUpViewState.Error(result.message)
                SignUpResult.SignUpSuccess -> _viewState.value = SignUpViewState.Success
            }
            _viewState.value = SignUpViewState.HideLoading
        }
    }
}