package com.example.drivingschool.models

data class Instructor(
    val id: Int?,
    val staff_number: String = "",
    val first_name: String? = "",
    val middle_name: String? = "",
    val last_name: String? = "",
    val email: String? = ""
)
