package com.realpacific.vehiclemanagement.repositories

import com.realpacific.vehiclemanagement.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, String> {

    @Query("SELECT u,v FROM User u JOIN FETCH u.vehicles v")
    fun findAllUserAndAssociatedVehicles(): List<User>

    @Query("SELECT u FROM User u WHERE u.email=:email")
    fun findUserByEmail(email: String): User?


    @Query("SELECT u FROM User u WHERE u.email=:email AND u.password=:password")
    fun findUserByEmailAndPassword(email: String, password: String): User?
}