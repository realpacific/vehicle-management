package com.realpacific.vehiclemanagement.entities

import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

@Entity
@Table(name = "tbl_user")
data class User constructor(
        @field:Email
        @field:NotBlank(message = "Email cannot be empty.")
        @field:Column(unique = true)
        var email: String,

        var password: String,

        @field:NotBlank(message = "Name cannot be empty.")
        var name: String,
        var address: String,


        @field:NotBlank(message = "Phone cannot be empty.")
        @field:Column(unique = true)
        @field:Size(min = 7, message = "Phone number must be valid.")
        @field:Pattern(regexp = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*\$")
        var phone: String
) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null


    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    var vehicles: List<Vehicle> = mutableListOf()

    @OneToMany(mappedBy = "user")
    var billings: List<Billing> = mutableListOf()
}