package com.example.drivingschool.models

data class LoginResponse(
    val token:String,
    val data:User
):CommonResponse()

data class User(
    val id:Int,
    val student_id:Int,
    val first_name:String,
    val middle_name:String,
    val last_name:String,
    val email:String,
    val phone:String,
    val gender:String,
    val email_verified_at:String?,
    val is_api_user:Int,
    val status:Int,
    val created_at:String,
    val updated_at:String,
    val student:Student,
)