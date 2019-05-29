package com.realpacific.vehiclemanagement.services

import com.realpacific.vehiclemanagement.entities.AuthenticateModel
import com.realpacific.vehiclemanagement.entities.User

interface UserService {
    fun saveOneUser(user: User): User
    fun getOneUserByEmail(email: String): User
    fun getAllUsers(): List<User>
    fun authenticateUser(authenticateModel: AuthenticateModel): User
}