package com.example.drivingschool.models

data class GetStudentResponse(
    val data: GetStudentDataObject
) : BaseCommonResponse()

data class GetStudentDataObject(val student: Student)
