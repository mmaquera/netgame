package com.boris.netgame.usecases

/*import com.boris.netgame.data.model.ResultType
import com.boris.netgame.data.repository.SignUpRepository
import com.boris.netgame.domain.result.SignUpResult
import javax.inject.Inject

class SignUpUseCase @Inject constructor(private val repository: SignUpRepository) {

    suspend operator fun invoke(userName: String, password: String): SignUpResult {
        return when (val result = repository.signUp(userName, password)) {
            is ResultType.AnotherError -> SignUpResult.SignUpError(result.e.message.toString())
            is ResultType.Error -> SignUpResult.SignUpError(result.error)
            is ResultType.Success -> SignUpResult.SignUpSuccess
        }
    }
}*/