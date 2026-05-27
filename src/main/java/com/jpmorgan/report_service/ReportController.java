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

    @GetMapping("/reports")
    public Map<String, String> getReports(){
        Map<String, String> response = new HashMap<>();
        response.put("status", "running");
        response.put("service", "JPMorgan Report Service");
        response.put("version", "1.0");
        return response;
    }
    @GetMapping("/reports/status")
    public Map<String, String> getStatus() {
        Map<String, String> status = new HashMap<>();
        status.put("health", "UP");
        status.put("database", "connected");
        status.put("reportCount", "120");
        return status;
    }
    @GetMapping("/reports/{id}")
    public Map<String, String> getReportById(@PathVariable int id) {
        Map<String, String> report = new HashMap<>();
        report.put("reportId", String.valueOf(id));
        report.put("name", "Capital Assessment Report");
        report.put("status", "completed");
        return report;
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
