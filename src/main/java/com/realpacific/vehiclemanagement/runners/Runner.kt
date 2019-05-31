package com.realpacific.vehiclemanagement.runners

import com.realpacific.vehiclemanagement.entities.*
import com.realpacific.vehiclemanagement.repositories.BillingRepository
import com.realpacific.vehiclemanagement.repositories.ReportRepository
import com.realpacific.vehiclemanagement.repositories.UserRepository
import com.realpacific.vehiclemanagement.repositories.VehicleRepository
import com.realpacific.vehiclemanagement.utils.getFutureDate
import com.realpacific.vehiclemanagement.utils.getPastDate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Component
import java.math.BigDecimal


@Component
@ConditionalOnProperty(prefix = "job.autorun", name = ["enabled"], havingValue = "true", matchIfMissing = true)
class Runner : CommandLineRunner {

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var vehicleRepository: VehicleRepository

    @Autowired
    lateinit var reportRepository: ReportRepository

    @Autowired
    lateinit var billingRepository: BillingRepository

    override fun run(vararg args: String?) {
        println("Saving...")

        val vehicle1 = Vehicle("BA1CHA1234", "i10")
        val vehicle2 = Vehicle("BA1CHA1235", "i20")
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


        for (dbUser in userRepository.findAllUserAndAssociatedVehicles()) {
            println(dbUser)
            println(dbUser.vehicles)
        }

        val billing = Billing(BigDecimal(1000), renewedAt = getPastDate(0), expiresAt = getFutureDate(1))
        billing.user = user
        billingRepository.save(billing)
    }
}