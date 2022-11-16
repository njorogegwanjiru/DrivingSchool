package com.example.drivingschool.domain.repositories

import com.example.drivingschool.utils.Resource
import com.example.drivingschool.models.*
import kotlinx.coroutines.flow.Flow

interface StudentsRepository {
    suspend fun getStudent(admissionNumberRequest: AdmissionNumberRequest): Flow<Resource<GetStudentResponse>>

    suspend fun getFeePaymentDetails(admissionNumberRequest: AdmissionNumberRequest): Flow<Resource<FeePaymentResponse>>

    suspend fun getCompletedLessons(admissionNumberRequest: AdmissionNumberRequest): Flow<Resource<CompletedLessonsResponse>>

    suspend fun getAllStudentDetails(admissionNumberRequest: AdmissionNumberRequest): Flow<Resource<AllStudentDetailsResponse>>
}