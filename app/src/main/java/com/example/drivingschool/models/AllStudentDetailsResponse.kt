package com.example.drivingschool.models

data class AllStudentDetailsResponse(
    val data: StudentDetails
) : CommonResponse()

data class StudentDetails(
    val student: Student,
    val feeBalance: Int,
    val remainingLessons: Int,
)