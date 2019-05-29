package com.realpacific.vehiclemanagement.repositories

import com.realpacific.vehiclemanagement.entities.Billing
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BillingRepository : JpaRepository<Billing, Long> {
}