package com.realpacific.vehiclemanagement.entities

data class BaseResponse<T>
constructor(
        val data: T,
        val message: String
)