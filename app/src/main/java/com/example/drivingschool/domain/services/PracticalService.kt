package com.example.drivingschool.domain.services

import com.example.drivingschool.models.BaseCommonResponse
import com.example.drivingschool.models.BookPracticalRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface PracticalService {
    //book practical
    @POST("book-practical")
    suspend fun bookPracticals(@Body bookPracticalRequest: BookPracticalRequest): BaseCommonResponse

}