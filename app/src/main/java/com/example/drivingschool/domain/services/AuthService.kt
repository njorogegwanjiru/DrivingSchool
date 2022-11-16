package com.example.drivingschool.domain.services

import com.example.drivingschool.models.*
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    //register
    @POST("register")
    suspend fun register(@Body registerRequest: RegisterRequest): BaseCommonResponse

    //login
    @POST("login")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse

    //logout
    @POST("logout")
    suspend fun logout(): BaseCommonResponse

    //request password reset
    @POST("request-password-reset")
    suspend fun requestPasswordReset(@Body initialPasswordResetRequest: InitialPasswordResetRequest): BaseCommonResponse

  //verify password reset code
    @POST("verify-password-reset-code")
    suspend fun verifyPasswordResetCode(@Body verifyPasswordResetCodeRequest: VerifyPasswordResetCodeRequest): BaseCommonResponse

  //reset password
    @POST("reset-password")
    suspend fun resetPassword(@Body resetPasswordRequest: ResetPasswordRequest): BaseCommonResponse
}