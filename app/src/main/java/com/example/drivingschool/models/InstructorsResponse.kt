package com.example.drivingschool.models

data class InstructorsResponse(
    val data:InstructorsDataObject
) : CommonResponse()

data class InstructorsDataObject(val instructors: List<Instructor>)

