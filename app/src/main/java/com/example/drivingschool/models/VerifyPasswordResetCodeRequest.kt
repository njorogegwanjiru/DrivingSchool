package com.example.drivingschool.models

data class VerifyPasswordResetCodeRequest(
    val email: String,
    val code: String
)