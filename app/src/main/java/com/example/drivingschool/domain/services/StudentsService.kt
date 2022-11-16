package com.example.drivingschool.domain.services

import com.example.drivingschool.models.*
import retrofit2.http.Body
import retrofit2.http.POST

interface StudentsService {
    //get student
    @POST("student/details")
    suspend fun getStudent(@Body admissionNumberRequest: AdmissionNumberRequest): GetStudentResponse

    //get fee payment details
    @POST("student/fee-payments")
    suspend fun getFeePaymentDetails(@Body admissionNumberRequest: AdmissionNumberRequest): FeePaymentResponse

   //get completed lessons
    @POST("student/completed-lessons")
    suspend fun getCompletedLessons(@Body admissionNumberRequest: AdmissionNumberRequest): CompletedLessonsResponse

   //get all student details
    @POST("student/all")
    suspend fun getAllStudentDetails(@Body admissionNumberRequest: AdmissionNumberRequest): AllStudentDetailsResponse


}