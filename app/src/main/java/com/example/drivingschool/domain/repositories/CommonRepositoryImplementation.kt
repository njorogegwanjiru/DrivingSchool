package com.example.drivingschool.domain.repositories

import com.example.drivingschool.utils.Resource
import com.example.drivingschool.domain.services.InstructorService
import com.example.drivingschool.domain.services.PracticalService
import com.example.drivingschool.domain.services.VehicleService
import com.example.drivingschool.models.BaseCommonResponse
import com.example.drivingschool.models.BookPracticalRequest
import com.example.drivingschool.models.GetTrainingVehicleResponse
import com.example.drivingschool.models.InstructorsResponse
import com.google.gson.GsonBuilder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CommonRepositoryImplementation @Inject constructor(
    private val instructorService: InstructorService,
    private val practicalService: PracticalService,
    private val vehicleService: VehicleService,
):CommonRepository{
    override suspend fun getInstructors(): Flow<Resource<InstructorsResponse>> {
        return flow {
            try {
                emit(Resource.Loading(isLoading = true))
                val response = instructorService.getInstructors()
                emit(Resource.Success(data = response))
                emit(Resource.Loading(isLoading = false))
            }
            catch (e: IOException) {
                emit(Resource.Error(description = "error"))
            }
            catch (e: HttpException) {
                if (e.response()?.errorBody() != null) {
                    val gson = GsonBuilder().create()
                    val mError: BaseCommonResponse = gson.fromJson(
                        e.response()?.errorBody()!!.string(),
                        BaseCommonResponse::class.java
                    )
                    emit(
                        Resource.Error(
                            status = mError.status,
                            description = mError.description,
                            errors = mError.errors
                        )
                    )
                }
            }
        }
    }

    override suspend fun bookPracticals(bookPracticalRequest: BookPracticalRequest): Flow<Resource<BaseCommonResponse>> {
        return flow {
            try {
                emit(Resource.Loading(isLoading = true))
                val response = practicalService.bookPracticals(bookPracticalRequest=bookPracticalRequest)
                emit(Resource.Success(data = response))
                emit(Resource.Loading(isLoading = false))
            }
            catch (e: IOException) {
                emit(Resource.Error(description = "error"))
            }
            catch (e: HttpException) {
                if (e.response()?.errorBody() != null) {
                    val gson = GsonBuilder().create()
                    val mError: BaseCommonResponse = gson.fromJson(
                        e.response()?.errorBody()!!.string(),
                        BaseCommonResponse::class.java
                    )
                    emit(
                        Resource.Error(
                            status = mError.status,
                            description = mError.description,
                            errors = mError.errors
                        )
                    )
                }
            }
        }
    }

    override suspend fun getTrainingVehicles(): Flow<Resource<GetTrainingVehicleResponse>> {
        return flow {
            try {
                emit(Resource.Loading(isLoading = true))
                val response = vehicleService.getTrainingVehicles()
                emit(Resource.Success(data = response))
                emit(Resource.Loading(isLoading = false))
            }
            catch (e: IOException) {
                emit(Resource.Error(description = "error"))
            }
            catch (e: HttpException) {
                if (e.response()?.errorBody() != null) {
                    val gson = GsonBuilder().create()
                    val mError: BaseCommonResponse = gson.fromJson(
                        e.response()?.errorBody()!!.string(),
                        BaseCommonResponse::class.java
                    )
                    emit(
                        Resource.Error(
                            status = mError.status,
                            description = mError.description,
                            errors = mError.errors
                        )
                    )
                }
            }
        }    }

}