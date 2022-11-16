package com.example.drivingschool.models

data class GetTrainingVehicleResponse(
    val data: TrainingVehicleDataObject
) : CommonResponse()

data class TrainingVehicleDataObject(
    val trainingVehicles: List<TrainingVehicle>
)

data class TrainingVehicle(
    val id: Int,
    val name: String,
    val registration_number: String
)