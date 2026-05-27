package com.jpmorgan.report_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

@RestController
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {

        this.reportService = reportService;
    }

    @PostMapping("/reports")
    public Report createReport(@RequestBody Report newReport) {

        return reportService.addReport(newReport);
    }


    @GetMapping("/reports/all")
    public List<Report> getAllReports() {

        return reportService.getAllReports();
    }

    @PutMapping("/reports/{id}")
    public Report updateReport(@PathVariable int id, @RequestBody Report update) {
        return reportService.updateStatus(id, update.getStatus());
    }

    @DeleteMapping("/reports/{id}")
    public String deleteReport(@PathVariable int id) {
        boolean deleted = reportService.deleteReport(id);
        if (deleted) {
            return "Report " + id + " deleted.";
        } else {
            return "Report " + id + " not found.";
        }
    }

}
