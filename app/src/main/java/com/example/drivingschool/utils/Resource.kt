package com.example.drivingschool.utils

import com.example.drivingschool.models.ErrorObject

sealed class Resource<T>(
    val data: T? = null,
    status: Boolean? = null,
    description: String? = null,
    errors: Array<ErrorObject>? = null
) {
    class Loading<T>(val isLoading: Boolean = true) : Resource<T>()

    class Success<T>(data: T?) : Resource<T>(data = data)

    class Error<T>(
        status: Boolean? = null,
        description: String? = null,
        errors: Array<ErrorObject>? = null
    ) : Resource<T>(status = status, description = description, errors = errors)
}