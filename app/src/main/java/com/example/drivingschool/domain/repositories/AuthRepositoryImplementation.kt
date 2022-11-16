package com.example.drivingschool.domain.repositories

import com.example.drivingschool.utils.Resource
import com.example.drivingschool.domain.services.AuthService
import com.example.drivingschool.models.*
import com.google.gson.GsonBuilder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImplementation @Inject constructor(
    private val authService: AuthService
):AuthRepository {
    override suspend fun register(registerRequest: RegisterRequest): Flow<Resource<BaseCommonResponse>> {
        return flow {
            try {
                emit(Resource.Loading(isLoading = true))
                val response = authService.register(registerRequest = registerRequest)
                emit(Resource.Success(data = response))
                emit(Resource.Loading(isLoading = false))
            }
            catch (e: IOException) {
                emit(Resource.Error(description = "error"))
            }
            catch (e: HttpException) {
                if (e.response()?.errorBody() != null) {
                    val gson = GsonBuilder().create()
                    val mError: BaseCommonResponse = gson.fromJson(
                        e.response()?.errorBody()!!.string(),
                        BaseCommonResponse::class.java
                    )
                    emit(
                        Resource.Error(
                            status = mError.status,
                            description = mError.description,
                            errors = mError.errors
                        )
                    )
                }
            }
        }
    }

    override suspend fun login(loginRequest: LoginRequest): Flow<Resource<LoginResponse>> {
        return flow {
            try {
                emit(Resource.Loading(isLoading = true))
                val response = authService.login(loginRequest = loginRequest)
                emit(Resource.Success(data = response))
                emit(Resource.Loading(isLoading = false))
            }
            catch (e: IOException) {
                emit(Resource.Error(description = "error"))
            }
            catch (e: HttpException) {
                if (e.response()?.errorBody() != null) {
                    val gson = GsonBuilder().create()
                    val mError: BaseCommonResponse = gson.fromJson(
                        e.response()?.errorBody()!!.string(),
                        BaseCommonResponse::class.java
                    )
                    emit(
                        Resource.Error(
                            status = mError.status,
                            description = mError.description,
                            errors = mError.errors
                        )
                    )
                }
            }
        }
    }

    override suspend fun logout(): Flow<Resource<BaseCommonResponse>> {
        return flow {
            try {
                emit(Resource.Loading(isLoading = true))
                val response = authService.logout()
                emit(Resource.Success(data = response))
                emit(Resource.Loading(isLoading = false))
            }
            catch (e: IOException) {
                emit(Resource.Error(description = "error"))
            }
            catch (e: HttpException) {
                if (e.response()?.errorBody() != null) {
                    val gson = GsonBuilder().create()
                    val mError: BaseCommonResponse = gson.fromJson(
                        e.response()?.errorBody()!!.string(),
                        BaseCommonResponse::class.java
                    )
                    emit(
                        Resource.Error(
                            status = mError.status,
                            description = mError.description,
                            errors = mError.errors
                        )
                    )
                }
            }
        }    }

    override suspend fun requestPasswordReset(initialPasswordResetRequest: InitialPasswordResetRequest): Flow<Resource<BaseCommonResponse>> {
        return flow {
            try {
                emit(Resource.Loading(isLoading = true))
                val response = authService.requestPasswordReset(initialPasswordResetRequest = initialPasswordResetRequest)
                emit(Resource.Success(data = response))
                emit(Resource.Loading(isLoading = false))
            }
            catch (e: IOException) {
                emit(Resource.Error(description = "error"))
            }
            catch (e: HttpException) {
                if (e.response()?.errorBody() != null) {
                    val gson = GsonBuilder().create()
                    val mError: BaseCommonResponse = gson.fromJson(
                        e.response()?.errorBody()!!.string(),
                        BaseCommonResponse::class.java
                    )
                    emit(
                        Resource.Error(
                            status = mError.status,
                            description = mError.description,
                            errors = mError.errors
                        )
                    )
                }
            }
        }
    }

    override suspend fun verifyPasswordResetCode(verifyPasswordResetCodeRequest: VerifyPasswordResetCodeRequest): Flow<Resource<BaseCommonResponse>> {
        return flow {
            try {
                emit(Resource.Loading(isLoading = true))
                val response = authService.verifyPasswordResetCode(verifyPasswordResetCodeRequest = verifyPasswordResetCodeRequest)
                emit(Resource.Success(data = response))
                emit(Resource.Loading(isLoading = false))
            }
            catch (e: IOException) {
                emit(Resource.Error(description = "error"))
            }
            catch (e: HttpException) {
                if (e.response()?.errorBody() != null) {
                    val gson = GsonBuilder().create()
                    val mError: BaseCommonResponse = gson.fromJson(
                        e.response()?.errorBody()!!.string(),
                        BaseCommonResponse::class.java
                    )
                    emit(
                        Resource.Error(
                            status = mError.status,
                            description = mError.description,
                            errors = mError.errors
                        )
                    )
                }
            }
        }
    }

    override suspend fun resetPassword(resetPasswordRequest: ResetPasswordRequest): Flow<Resource<BaseCommonResponse>> {
        return flow {
            try {
                emit(Resource.Loading(isLoading = true))
                val response = authService.resetPassword(resetPasswordRequest = resetPasswordRequest)
                emit(Resource.Success(data = response))
                emit(Resource.Loading(isLoading = false))
            }
            catch (e: IOException) {
                emit(Resource.Error(description = "error"))
            }
            catch (e: HttpException) {
                if (e.response()?.errorBody() != null) {
                    val gson = GsonBuilder().create()
                    val mError: BaseCommonResponse = gson.fromJson(
                        e.response()?.errorBody()!!.string(),
                        BaseCommonResponse::class.java
                    )
                    emit(
                        Resource.Error(
                            status = mError.status,
                            description = mError.description,
                            errors = mError.errors
                        )
                    )
                }
            }
        }
    }

}