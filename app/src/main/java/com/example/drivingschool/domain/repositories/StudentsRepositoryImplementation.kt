package com.example.drivingschool.domain.repositories

import com.example.drivingschool.utils.Resource
import com.example.drivingschool.domain.services.StudentsService
import com.example.drivingschool.models.*
import com.google.gson.GsonBuilder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StudentsRepositoryImplementation @Inject constructor(
    private val studentsService:StudentsService
):StudentsRepository {
    override suspend fun getStudent(admissionNumberRequest: AdmissionNumberRequest): Flow<Resource<GetStudentResponse>> {
        return flow {
            try {
                emit(Resource.Loading(isLoading = true))
                val response = studentsService.getStudent(admissionNumberRequest = admissionNumberRequest)
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

    override suspend fun getFeePaymentDetails(admissionNumberRequest: AdmissionNumberRequest): Flow<Resource<FeePaymentResponse>> {
        return flow {
            try {
                emit(Resource.Loading(isLoading = true))
                val response = studentsService.getFeePaymentDetails(admissionNumberRequest = admissionNumberRequest)
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

    override suspend fun getCompletedLessons(admissionNumberRequest: AdmissionNumberRequest): Flow<Resource<CompletedLessonsResponse>> {
        return flow {
            try {
                emit(Resource.Loading(isLoading = true))
                val response = studentsService.getCompletedLessons(admissionNumberRequest = admissionNumberRequest)
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

    override suspend fun getAllStudentDetails(admissionNumberRequest: AdmissionNumberRequest): Flow<Resource<AllStudentDetailsResponse>> {
        return flow {
            try {
                emit(Resource.Loading(isLoading = true))
                val response = studentsService.getAllStudentDetails(admissionNumberRequest = admissionNumberRequest)
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

}