package com.realpacific.vehiclemanagement.entities

data class AuthenticateModel(var email: String?, var password: String?) {
    constructor(): this(null, null)
}