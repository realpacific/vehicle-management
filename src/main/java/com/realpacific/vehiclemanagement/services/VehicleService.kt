package com.realpacific.vehiclemanagement.services

import com.realpacific.vehiclemanagement.entities.Vehicle
import com.realpacific.vehiclemanagement.exceptions.VehicleNotFoundException

interface VehicleService {
    fun getAllVehicleForEmail(email: String): List<Vehicle>
    fun addNewVehicle(vehicle: Vehicle, email: String)
    fun updateVehicle(vehicle: Vehicle)

    @Throws(VehicleNotFoundException::class)
    fun getVehicleByPlateNo(plateNo: String): Vehicle
}