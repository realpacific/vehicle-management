package com.realpacific.vehiclemanagement.entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.*
import javax.persistence.*
import javax.validation.constraints.Size

@Entity
@Table(name = "tbl_vehicle")
@JsonIgnoreProperties(value = ["user"])
data class Vehicle constructor(
        @Size(max = 15, min = 5, message = "Plate Number must be correct")
        @Column(unique = true)
        var plateNo: String,

        @Column(nullable = false)
        var model: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    @Column(updatable = false)
    @CreationTimestamp
    var createdOn: Date? = null

    @UpdateTimestamp
    var updatedOn: Date? = null


    @ManyToOne(fetch = FetchType.LAZY)
    lateinit var user: User

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToMany(mappedBy = "vehicle")
    var reports: MutableList<Report>? = mutableListOf()
}