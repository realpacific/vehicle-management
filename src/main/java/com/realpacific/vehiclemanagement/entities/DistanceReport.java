package com.realpacific.vehiclemanagement.entities;

import javax.persistence.Entity;

@Entity(name = "tbl_distance_report")
public class DistanceReport extends Report {

    private Long remindAfterTravelling;
    private Long renewedAtDistance;

    private DistanceReport() {
    }

    public DistanceReport(Vehicle vehicle, String name, String description, Long renewedAtDistance, Long remindAfterTravelling) {
        super(vehicle, name, description);
        this.renewedAtDistance = renewedAtDistance;
        this.remindAfterTravelling = remindAfterTravelling;
    }
}