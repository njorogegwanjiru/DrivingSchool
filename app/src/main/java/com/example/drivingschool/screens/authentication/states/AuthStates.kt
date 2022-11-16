package com.example.drivingschool.screens.authentication.states

import com.example.drivingschool.models.BaseCommonResponse
import com.example.drivingschool.models.ErrorObject
import com.example.drivingschool.models.LoginResponse

data class BaseState(
    var isLoading: Boolean = false,
    val errors: Array<ErrorObject>? = null,
    val baseCommonResponse: BaseCommonResponse? = null,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BaseState

        if (isLoading != other.isLoading) return false
        if (errors != null) {
            if (other.errors == null) return false
            if (!errors.contentEquals(other.errors)) return false
        } else if (other.errors != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = isLoading.hashCode()
        result = 31 * result + (errors?.contentHashCode() ?: 0)
        return result
    }
}

data class LoginState(
    var isLoading: Boolean = false,
    val errors: Array<ErrorObject>? = null,
    val loginResponse: LoginResponse? = null,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LoginState

        if (isLoading != other.isLoading) return false
        if (errors != null) {
            if (other.errors == null) return false
            if (!errors.contentEquals(other.errors)) return false
        } else if (other.errors != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = isLoading.hashCode()
        result = 31 * result + (errors?.contentHashCode() ?: 0)
        return result
    }
}

