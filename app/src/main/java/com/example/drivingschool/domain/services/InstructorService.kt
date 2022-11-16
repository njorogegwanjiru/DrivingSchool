package com.example.drivingschool.domain.services

import com.example.drivingschool.models.InstructorsResponse
import retrofit2.http.POST

interface InstructorService {
    //get all instructors
    @POST("instructor/get")
    suspend fun getInstructors(): InstructorsResponse

}