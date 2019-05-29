package com.realpacific.vehiclemanagement.repositories

import com.realpacific.vehiclemanagement.entities.Vehicle
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface VehicleRepository : JpaRepository<Vehicle, String> {

    @Query("SELECT v FROM Vehicle v JOIN v.user u WHERE u.email=:email")
    fun findAllVehiclesByEmail(email: String): List<Vehicle>

    fun findVehicleByPlateNo(plateNo: String): Vehicle?
}