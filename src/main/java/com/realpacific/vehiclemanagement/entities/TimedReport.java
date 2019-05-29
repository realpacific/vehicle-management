package com.realpacific.vehiclemanagement.entities;

import javax.persistence.Entity;
import java.util.Date;

@Entity(name = "tbl_timed_report")
public class TimedReport extends Report {

    private Date renewedAt;
    private Date expiration;

    private TimedReport() {
    }

    public TimedReport(Vehicle vehicle, String name, String description, Date renewedAt, Date expiration) {
        super(vehicle, name, description);
        this.renewedAt = renewedAt;
        this.expiration = expiration;
    }
}
