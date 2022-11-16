package com.example.drivingschool.models

open class CommonResponse(
    val status: Boolean = false,
    val description: String = "",
    val errors: Array<ErrorObject> = arrayOf(),
)

data class ErrorObject(
    val errorValues: Map<String, Array<String>>
)

open class BaseCommonResponse(
    val message: String = ""
) : CommonResponse()

