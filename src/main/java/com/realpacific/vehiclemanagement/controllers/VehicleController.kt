package com.realpacific.vehiclemanagement.controllers

import com.realpacific.vehiclemanagement.constants.AppConstant
import com.realpacific.vehiclemanagement.entities.BaseResponse
import com.realpacific.vehiclemanagement.entities.Vehicle
import com.realpacific.vehiclemanagement.services.VehicleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class VehicleController {

    @Autowired
    lateinit var vehicleService: VehicleService

    @PostMapping("/user/{email}/vehicles")
    fun addNewVehicleToUser(@PathVariable email: String, @RequestBody vehicle: Vehicle) {
        vehicleService.addNewVehicle(vehicle, email)
    }

    @GetMapping("/user/{email}/vehicles")
    fun retrieveAllVehicleForEmail(@PathVariable email: String): ResponseEntity<BaseResponse<List<Vehicle>>> {
        val list = vehicleService.getAllVehicleForEmail(email)
        return ResponseEntity.ok(BaseResponse(list, AppConstant.MESSAGE_OK))
    }


    @GetMapping("/user/vehicles/{plateNo}")
    fun retrieveVehicleByPlateNo(@PathVariable plateNo: String): ResponseEntity<BaseResponse<Vehicle>> {
        val vehicle = vehicleService.getVehicleByPlateNo(plateNo)
        return ResponseEntity.ok(BaseResponse(vehicle, AppConstant.MESSAGE_OK))
    }

}