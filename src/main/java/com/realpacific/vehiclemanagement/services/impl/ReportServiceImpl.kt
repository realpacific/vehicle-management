package com.realpacific.vehiclemanagement.services.impl

import com.realpacific.vehiclemanagement.entities.Report
import com.realpacific.vehiclemanagement.repositories.ReportRepository
import com.realpacific.vehiclemanagement.services.ReportService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ReportServiceImpl : ReportService {
    @Autowired
    lateinit var repository: ReportRepository

    override fun getReportByPlateNo(plateNo: String): List<Report> {
        return repository.findAllReportsByPlateNo(plateNo)
    }

    override fun addReport(plateNo: String, report: Report) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateReport(plateNo: String, report: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteReport(plateNo: String, report: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}