package com.boris.netgame.usecases

import com.boris.netgame.data.model.ResultType
import com.boris.netgame.data.repository.AuthenticateRepository
import com.boris.netgame.domain.result.SignInResult
import com.boris.netgame.usecases.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AuthenticationUseCase @Inject constructor(
    private val authenticateRepository: AuthenticateRepository,
    @IoDispatcher private val coroutineDispatcher: CoroutineDispatcher
) {

    operator fun invoke(username: String, password: String) = authenticateRepository.signIn(
        userName = username, password = password
    ).map { result ->
        return@map when (result) {
            is ResultType.Success -> SignInResult.AuthenticationResult.Authorization
            is ResultType.Error -> SignInResult.AuthenticationResult.Denied(result.error)
            is ResultType.AnotherError -> SignInResult.AuthenticationResult.AnotherError
        }
    }.flowOn(context = coroutineDispatcher)
}
