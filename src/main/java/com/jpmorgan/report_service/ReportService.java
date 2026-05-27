package com.jpmorgan.report_service;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReportService {

    private final ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    // READ — get all reports from the database
    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    // CREATE — save a new report to the database
    public Report addReport(Report report) {
        return reportRepository.save(report);
    }

    // UPDATE — find by id, change status, save
    public Report updateStatus(int id, String newStatus) {
        Report report = reportRepository.findById(id).orElse(null);
        if (report != null) {
            report.setStatus(newStatus);
            return reportRepository.save(report);
        }
        return null;
    }

    // DELETE — remove by id
    public boolean deleteReport(int id) {
        if (reportRepository.existsById(id)) {
            reportRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

//this is the comment 