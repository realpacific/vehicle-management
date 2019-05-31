package com.realpacific.vehiclemanagement.repositories

import com.realpacific.vehiclemanagement.entities.Report
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ReportRepository : JpaRepository<Report, String> {
    @Query("SELECT s FROM Report s JOIN s.vehicle v WHERE v.plateNo=:plateNo")
    fun findAllReportsByPlateNo(plateNo: String): List<Report>

}