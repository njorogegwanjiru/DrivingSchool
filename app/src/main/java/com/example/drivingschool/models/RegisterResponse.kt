package com.example.drivingschool.models

data class RegisterResponse(
    val data: RegisterDataObject
):CommonResponse()

data class RegisterDataObject(val message: String)
