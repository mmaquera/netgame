package com.boris.netgame.usecases

import com.boris.netgame.data.model.ResultType
import com.boris.netgame.data.repository.AuthenticateRepository
import com.boris.netgame.domain.result.AuthenticationResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthenticationUseCase @Inject constructor(private val authenticateRepository: AuthenticateRepository) {

    suspend operator fun invoke(username: String, password: String): Flow<AuthenticationResult> = flow {
        when (val result = authenticateRepository.signIn(username, password)) {
            is ResultType.Success<*> -> emit(AuthenticationResult.Authorization)
            is ResultType.Error<*> -> emit(AuthenticationResult.Denied(result.error))
            is ResultType.AnotherError<*> -> emit(AuthenticationResult.AnotherError)
            //else -> emit(AuthenticationResult.AnotherError)
        }
    }
}
