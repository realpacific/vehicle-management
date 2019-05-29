package com.realpacific.vehiclemanagement.entities;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_report")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Vehicle vehicle;

    private String name;
    private String description;

    @CreationTimestamp
    private Date createdOn;

    protected Report() {
    }

    protected Report(Vehicle vehicle, String name, String description) {
        this.vehicle = vehicle;
        this.name = name;
        this.description = description;
    }
}
