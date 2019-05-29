package com.realpacific.vehiclemanagement.entities

import org.intellij.lang.annotations.RegExp
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.Size

@Entity
@Table(name = "tbl_user")
data class User constructor(
        @Id
        var id: String,

        @Email
        @Column(unique = true, nullable = false)
        var email: String,

        var password: String,

        @Column(nullable = false)
        var name: String,
        var address: String,


        @Column(unique = true, nullable = false)
        @Size(min = 8)
        @RegExp(prefix = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*\$")
        var phone: String
) {

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    var vehicles: List<Vehicle> = mutableListOf()

    @OneToMany(mappedBy = "user")
    var billings: List<Billing> = mutableListOf()
}