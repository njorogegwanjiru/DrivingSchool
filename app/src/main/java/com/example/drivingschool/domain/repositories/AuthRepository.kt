package com.example.drivingschool.domain.repositories

import com.example.drivingschool.utils.Resource
import com.example.drivingschool.models.*
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun register(registerRequest: RegisterRequest): Flow<Resource<BaseCommonResponse>>

    suspend fun login(loginRequest: LoginRequest): Flow<Resource<LoginResponse>>

    suspend fun logout(): Flow<Resource<BaseCommonResponse>>

    suspend fun requestPasswordReset(initialPasswordResetRequest: InitialPasswordResetRequest): Flow<Resource<BaseCommonResponse>>

    suspend fun verifyPasswordResetCode(verifyPasswordResetCodeRequest: VerifyPasswordResetCodeRequest): Flow<Resource<BaseCommonResponse>>

    suspend fun resetPassword(resetPasswordRequest: ResetPasswordRequest): Flow<Resource<BaseCommonResponse>>
}