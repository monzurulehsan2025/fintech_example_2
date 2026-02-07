package com.amex.dashboard_service.controller;

import com.amex.dashboard_service.model.Metrics;
import com.amex.dashboard_service.model.Project;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*") // Allow frontend to access
public class DashboardController {

    private final List<Metrics> metricsHistory = new ArrayList<>();

    public DashboardController() {
        // Initialize with default metric including cloudMigrationSpeed (85.5%)
        metricsHistory.add(new Metrics(1250000, 99.98, 45, 0.02, 85.5));
    }

    @GetMapping("/dashboard/metrics")
    public Metrics getDashboardMetrics() {
        return metricsHistory.get(metricsHistory.size() - 1);
    }

    @GetMapping("/dashboard/metrics/history")
    public List<Metrics> getMetricsHistory() {
        return metricsHistory;
    }

    @GetMapping("/projects")
    public List<Project> getProjects() {
        // Mock project data relevant for modernizing web apps (React/Angular mentioned
        // in JD)
        return Arrays.asList(
                new Project("1", "MYCA React Migration", "In Progress", "Sarah Johnson", 65),
                new Project("2", "Global Rewards Portal", "Planning", "Michael Chen", 10),
                new Project("3", "Membership Automation API", "In Progress", "Emily Rodriguez", 40),
                new Project("4", "Travel & Lifestyle Dashboard", "Completed", "David Smith", 100));
    }
}
