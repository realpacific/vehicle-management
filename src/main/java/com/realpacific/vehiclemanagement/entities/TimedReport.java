package com.realpacific.vehiclemanagement.entities;

import javax.persistence.Entity;
import javax.validation.constraints.Future;
import java.util.Date;

@Entity(name = "tbl_timed_report")
public class TimedReport extends Report {

    private Date renewedOn;

    @Future
    private Date expiration;

    private TimedReport() {
    }

    public TimedReport(Vehicle vehicle, String name, String description, Date renewedOn, Date expiration) {
        super(vehicle, name, description);
        this.renewedOn = renewedOn;
        this.expiration = expiration;
    }

    public Date getRenewedOn() {
        return renewedOn;
    }

    public void setRenewedOn(Date renewedOn) {
        this.renewedOn = renewedOn;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }
}
