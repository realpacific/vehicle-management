package com.realpacific.vehiclemanagement.services

import com.realpacific.vehiclemanagement.entities.Report

interface ReportService {
    fun getReportByPlateNo(plateNo: String): List<Report>
    fun addReport(plateNo: String, report: Report)
    fun updateReport(plateNo: String, report: String)
    fun deleteReport(plateNo: String, report: String)
}
