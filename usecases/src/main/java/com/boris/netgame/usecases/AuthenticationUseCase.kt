package com.boris.netgame.usecases

import com.boris.netgame.data.repository.AuthenticateRepository
import javax.inject.Inject

class AuthenticationUseCase @Inject constructor(private val authenticateRepository: AuthenticateRepository) {

    suspend operator fun invoke(username: String, password: String) {
        authenticateRepository.signIn(username, password)
    }
}
