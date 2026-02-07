package com.amex.dashboard_service.controller;

import com.amex.dashboard_service.model.Metrics;
import com.amex.dashboard_service.model.Project;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*") // Allow frontend to access
public class DashboardController {

    private final List<Metrics> metricsHistory = new ArrayList<>();

    public DashboardController() {
        // Initialize with default metric including cloudMigrationSpeed (85.5%)
        metricsHistory.add(new Metrics(99.98, 45, 0.02, 85.5));
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
        List<Project> projects = new ArrayList<>();
        String[] prefixes = { "Global", "Cloud", "Digital", "Mobile", "Secure", "Smart", "Infinite", "Nexus", "Prime",
                "Quantum" };
        String[] suffixes = { "Platform", "Sync", "Gateway", "Vault", "Core", "Engine", "Network", "Portal", "Ledger",
                "Interface" };

        for (int i = 1; i <= 50; i++) {
            String id = String.valueOf(i);
            String name = prefixes[i % 10] + " " + suffixes[(i * 3) % 10] + " " + i;
            projects.add(new Project(id, name));
        }
        return projects;
    }
}
