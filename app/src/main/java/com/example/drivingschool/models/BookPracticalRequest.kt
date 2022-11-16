package com.example.drivingschool.models

data class BookPracticalRequest(
    val student_id: Int?,
    val instructor_id: Int?,
    val training_vehicle_id: Int?,
    val date: String?
)