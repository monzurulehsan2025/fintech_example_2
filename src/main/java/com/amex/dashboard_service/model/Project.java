package com.amex.dashboard_service.model;

public class Project {
    private String id;
    private String name;
    private String status;
    private String lead;
    private int completionPercentage;

    public Project(String id, String name, String status, String lead, int completionPercentage) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.lead = lead;
        this.completionPercentage = completionPercentage;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLead() {
        return lead;
    }

    public void setLead(String lead) {
        this.lead = lead;
    }

    public int getCompletionPercentage() {
        return completionPercentage;
    }

    public void setCompletionPercentage(int completionPercentage) {
        this.completionPercentage = completionPercentage;
    }
}
