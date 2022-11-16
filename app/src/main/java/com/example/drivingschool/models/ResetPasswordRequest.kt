package com.example.drivingschool.models

data class ResetPasswordRequest(
    val email: String,
    val password: String,
    val password_confirmation: String
)