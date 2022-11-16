package com.example.drivingschool.models

data class CourseType(
    val id:Int?=0,
    val name:String?="",
    val number_of_lessons:Int?=0,
    val status:Int?=0,
    val created_at:String?="",
    val updated_at:String?=""
)