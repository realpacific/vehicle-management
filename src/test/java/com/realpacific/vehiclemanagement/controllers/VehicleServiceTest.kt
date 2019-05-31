package com.realpacific.vehiclemanagement.controllers

import com.realpacific.vehiclemanagement.entities.User
import com.realpacific.vehiclemanagement.entities.Vehicle
import com.realpacific.vehiclemanagement.exceptions.NotFoundException
import com.realpacific.vehiclemanagement.exceptions.VehicleNotFoundException
import com.realpacific.vehiclemanagement.services.UserService
import com.realpacific.vehiclemanagement.services.VehicleService
import org.assertj.core.api.Assertions
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@SpringBootTest(properties = ["job.autorun.enabled=false"])
@RunWith(SpringRunner::class)
class VehicleServiceTest {

    @Autowired
    lateinit var vehicleService: VehicleService


    @Autowired
    lateinit var userService: UserService

    val vehicle1 = Vehicle("BA1CHA1234", "i10")
    val vehicle2 = Vehicle("BA1CHA1235", "i20")
    val user = User("prashantbarahi@gmail.com", "password",
            "Prashant Barahi", "Patan",
            "9849010616")

    @Before
    fun setup() {
        userService.saveOneUser(user)
        vehicleService.addNewVehicle(vehicle1, user.email)
        vehicleService.addNewVehicle(vehicle2, user.email)
    }

    @Test
    fun testForGetAllVehicles() {
        Assertions.assertThat(vehicleService.getAllVehicleForEmail(user.email)).hasSize(2)
    }

    @Test
    fun testForGetVehicleByPlateNo() {
        Assertions.assertThat(vehicleService.getVehicleByPlateNo(vehicle1.plateNo)).satisfies {
            it.plateNo == vehicle1.plateNo && it.model == vehicle1.model
        }
        Assertions.assertThatExceptionOfType(VehicleNotFoundException::class.java).isThrownBy {
            vehicleService.getVehicleByPlateNo("XYZ")
        }.withMessage("Vehicle not found.")

        Assertions.assertThatExceptionOfType(NotFoundException::class.java).isThrownBy {
            vehicleService.getVehicleByPlateNo("XYZ")
        }.withMessage("Vehicle not found.")

    }

}