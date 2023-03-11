package com.mmaquera.netgame.view.login.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.boris.netgame.domain.result.SignInResult
import com.boris.netgame.usecases.AuthenticationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(FlowPreview::class)
@HiltViewModel
class SignInViewModel @Inject constructor(
    private val authenticationUseCase: AuthenticationUseCase
) : ViewModel() {

    private val intentFlow = MutableSharedFlow<SignInIntent>()

    private val _uiState = MutableStateFlow<SignInUiState>(SignInUiState.Render)
    val uiState: StateFlow<SignInUiState> = _uiState.asStateFlow()

    private val _effect = Channel<SignInEffect>(Channel.BUFFERED)
    val effect = _effect.receiveAsFlow()

    init {
        viewModelScope.launch {
            intentFlow
                .map { intent -> intent.mapToAction() }
                .flatMapMerge { action -> processAction(action) }
                .map { result -> signInReduceState(result) }
                .collect {
                    if (it is SignInUiState.Authenticate){
                        _effect.send(SignInEffect.GoToMain)
                    } else{
                        _uiState.value = it
                    }
                }
        }
    }

    private fun processAction(signInAction: SignInAction): Flow<SignInResult> {
        return when (signInAction) {
            is SignInAction.Authenticate -> authenticationUseCase.invoke(
                username = signInAction.username,
                password = signInAction.password
            )
        }
    }

    private fun signInReduceState(result: SignInResult): SignInUiState {
        return when (result) {
            SignInResult.AuthenticationResult.Authorization -> SignInUiState.Authenticate
            is SignInResult.AuthenticationResult.Denied -> SignInUiState.Render
            SignInResult.AuthenticationResult.AnotherError -> SignInUiState.Error("hola")
        }
    }

    fun signInIntent(intent: SignInIntent) {
        viewModelScope.launch {
            intentFlow.emit(intent)
        }
    }

    fun goToMainEvent(effect: SignInEffect) {
        viewModelScope.launch {
            _effect.send(effect)
        }
    }
}