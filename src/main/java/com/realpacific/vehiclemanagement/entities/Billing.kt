package com.realpacific.vehiclemanagement.entities

import java.math.BigDecimal
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "tbl_billing")
data class Billing(
        var monthlyAmount: BigDecimal,
        var renewedAt: Date,
        var expiresAt: Date
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    @ManyToOne
    lateinit var user: User
}