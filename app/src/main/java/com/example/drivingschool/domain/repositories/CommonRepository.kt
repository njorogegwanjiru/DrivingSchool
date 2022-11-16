package com.example.drivingschool.domain.repositories

import com.example.drivingschool.utils.Resource
import com.example.drivingschool.models.BaseCommonResponse
import com.example.drivingschool.models.BookPracticalRequest
import com.example.drivingschool.models.GetTrainingVehicleResponse
import com.example.drivingschool.models.InstructorsResponse
import kotlinx.coroutines.flow.Flow

interface CommonRepository {
    suspend fun getInstructors(): Flow<Resource<InstructorsResponse>>

    suspend fun bookPracticals(bookPracticalRequest: BookPracticalRequest): Flow<Resource<BaseCommonResponse>>

    suspend fun getTrainingVehicles(): Flow<Resource<GetTrainingVehicleResponse>>

}