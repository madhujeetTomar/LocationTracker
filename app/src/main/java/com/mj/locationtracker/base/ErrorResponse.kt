package com.mj.locationtracker.base

data class ErrorResponse(var code: Int, var message: String) {

    var code1 = 0

    init {
        code1 = code
    }

    fun getErrorMessage(): String {
        when (code1) {
            400 -> return "Unable to reach server"
            401 -> return "Unable to reach server"
            500 -> return "Unable to reach server"
            else -> return "Unable to reach server"
        }


    }
}