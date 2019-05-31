package com.realpacific.vehiclemanagement.entities;

import javax.persistence.Entity;

@Entity(name = "tbl_servicing_report")
public class ServicingReport extends Report {

    private Long remindAfterTravelling;
    private Long renewedAtDistance;

    private ServicingReport() {
    }

    public ServicingReport(Vehicle vehicle, String name, String description, Long renewedAtDistance, Long remindAfterTravelling) {
        super(vehicle, name, description);
        this.renewedAtDistance = renewedAtDistance;
        this.remindAfterTravelling = remindAfterTravelling;
    }

    public Long getRemindAfterTravelling() {
        return remindAfterTravelling;
    }

    public void setRemindAfterTravelling(Long remindAfterTravelling) {
        this.remindAfterTravelling = remindAfterTravelling;
    }

    public Long getRenewedAtDistance() {
        return renewedAtDistance;
    }

    public void setRenewedAtDistance(Long renewedAtDistance) {
        this.renewedAtDistance = renewedAtDistance;
    }
}