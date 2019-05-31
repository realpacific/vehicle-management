package com.realpacific.vehiclemanagement.controllers

import com.realpacific.vehiclemanagement.constants.AppConstant
import com.realpacific.vehiclemanagement.entities.BaseResponse
import com.realpacific.vehiclemanagement.entities.Report
import com.realpacific.vehiclemanagement.services.ReportService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin("http://localhost:4200")
class ReportController {

    @Autowired
    lateinit var reportService: ReportService

    @GetMapping("/vehicles/{plateNo}")
    fun retrieveReportsForVehicle(@PathVariable plateNo: String): ResponseEntity<BaseResponse<List<Report>>> {
        return ok(BaseResponse(reportService.getReportByPlateNo(plateNo), AppConstant.MESSAGE_OK))
    }
}