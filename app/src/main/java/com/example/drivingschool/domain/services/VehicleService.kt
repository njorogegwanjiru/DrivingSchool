package com.example.drivingschool.domain.services

import com.example.drivingschool.models.GetTrainingVehicleResponse
import retrofit2.http.POST

interface VehicleService {
    //get training vehicles
    @POST("training-vehicle/get")
    suspend fun getTrainingVehicles(): GetTrainingVehicleResponse

}