package com.boris.netgame.usecases

import com.boris.netgame.data.model.ResultType
import com.boris.netgame.data.repository.AuthenticateRepository
import com.boris.netgame.domain.result.AuthenticationResult
import javax.inject.Inject

class AuthenticationUseCase @Inject constructor(private val authenticateRepository: AuthenticateRepository) {

    suspend operator fun invoke(username: String, password: String): AuthenticationResult {
        return when (val result = authenticateRepository.signIn(username, password)) {
            is ResultType.Success -> AuthenticationResult.Authorization
            is ResultType.Error -> AuthenticationResult.Denied(result.error)
            else -> AuthenticationResult.AnotherError
        }
    }
}
