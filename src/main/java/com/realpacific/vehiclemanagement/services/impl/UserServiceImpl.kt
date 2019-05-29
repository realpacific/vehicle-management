package com.realpacific.vehiclemanagement.services.impl

import com.realpacific.vehiclemanagement.entities.AuthenticateModel
import com.realpacific.vehiclemanagement.entities.User
import com.realpacific.vehiclemanagement.exceptions.AuthenticationException
import com.realpacific.vehiclemanagement.exceptions.UserNotFoundException
import com.realpacific.vehiclemanagement.repositories.UserRepository
import com.realpacific.vehiclemanagement.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService {
    @Autowired
    lateinit var repository: UserRepository

    override fun saveOneUser(user: User): User {
        return repository.save(user)
    }

    @Throws(UserNotFoundException::class)
    override fun getOneUserByEmail(email: String): User {
        return repository.findUserByEmail(email) ?: throw UserNotFoundException()
    }

    override fun getAllUsers(): List<User> = repository.findAll()

    override fun authenticateUser(authenticateModel: AuthenticateModel): User {
        val result = repository.findUserByEmailAndPassword(authenticateModel.email, authenticateModel.password)
        return result ?: throw AuthenticationException()
    }
}