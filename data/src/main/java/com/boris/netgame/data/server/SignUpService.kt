package com.boris.netgame.data.server


/*class SignUpService @Inject constructor(private val apiService: ApiService) : SignUpDataSource {

    override suspend fun signUp(userName: String, password: String): ResultType<Unit> {
        return try {
            val result = apiService.signUp(Register(userName = userName,password = password))

            return when(result.statusBody.code){
                Code.SUCCESS -> ResultType.Success(data = result.data)
                Code.ERROR -> ResultType.Error(error = result.statusBody.message)
            }
        }catch (e: Exception) {
            ResultType.AnotherError(e)
        }
    }
}*/