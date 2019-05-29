package com.realpacific.vehiclemanagement.services.impl

import com.realpacific.vehiclemanagement.entities.Vehicle
import com.realpacific.vehiclemanagement.exceptions.VehicleNotFoundException
import com.realpacific.vehiclemanagement.repositories.VehicleRepository
import com.realpacific.vehiclemanagement.services.UserService
import com.realpacific.vehiclemanagement.services.VehicleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class VehicleServiceImpl : VehicleService {
    @Autowired
    lateinit var repository: VehicleRepository

    @Autowired
    lateinit var userService: UserService

    override fun getAllVehicleForEmail(email: String): List<Vehicle> {
        return repository.findAllVehiclesByEmail(email)
    }

    override fun addNewVehicle(vehicle: Vehicle, email: String) {
        vehicle.user = userService.getOneUserByEmail(email)
        repository.save(vehicle)
    }

    override fun updateVehicle(vehicle: Vehicle) {
        repository.save(vehicle)
    }

    override fun getVehicleByPlateNo(plateNo: String): Vehicle {
        return repository.findVehicleByPlateNo(plateNo) ?: throw VehicleNotFoundException()
    }
}