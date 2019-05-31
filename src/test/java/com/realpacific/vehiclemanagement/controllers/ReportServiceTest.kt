package com.realpacific.vehiclemanagement.controllers

import com.realpacific.vehiclemanagement.entities.ServicingReport
import com.realpacific.vehiclemanagement.entities.TimedReport
import com.realpacific.vehiclemanagement.entities.User
import com.realpacific.vehiclemanagement.entities.Vehicle
import com.realpacific.vehiclemanagement.repositories.ReportRepository
import com.realpacific.vehiclemanagement.repositories.UserRepository
import com.realpacific.vehiclemanagement.repositories.VehicleRepository
import com.realpacific.vehiclemanagement.utils.getFutureDate
import com.realpacific.vehiclemanagement.utils.getPastDate
import org.assertj.core.api.Assertions
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner


@SpringBootTest(properties = ["job.autorun.enabled=false"])
@RunWith(SpringRunner::class)
class ReportServiceTest {

    @Autowired
    lateinit var reportRepository: ReportRepository

    @Autowired
    lateinit var vehicleRepository: VehicleRepository

    @Autowired
    lateinit var userRepository: UserRepository

    lateinit var vehicle1: Vehicle
    lateinit var vehicle2: Vehicle

    @Before
    fun setup() {

        vehicle1 = Vehicle("BA1CHA1234", "i10")
        vehicle2 = Vehicle("BA1CHA1235", "i20")
        val user = User("prashantbarahi@gmail.com", "password",
                "Prashant Barahi", "Patan",
                "9849010616")

        vehicle1.user = user
        vehicle2.user = user

        val report1 = TimedReport(vehicle1, "Renew reminder", "Go to DOTM",
                getPastDate(6), getFutureDate(1))

        val report2 = ServicingReport(vehicle1, "Do servicing", "Servicing asap",
                900000, 100000)

        userRepository.save(user)
        vehicleRepository.save(vehicle1)
        vehicleRepository.save(vehicle2)
        reportRepository.save(report1)
        reportRepository.save(report2)
    }

    @Test
    fun testForReportRetrieval() {
        Assertions.assertThat(reportRepository.findAllReportsByPlateNo(vehicle1.plateNo)).hasSize(2)
    }
}