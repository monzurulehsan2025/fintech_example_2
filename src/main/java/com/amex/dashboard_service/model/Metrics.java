package com.amex.dashboard_service.model;

public class Metrics {
    private long activeUsers;
    private double systemHealth;
    private int deploymentFrequency;
    private double errorRate;
    private double cloudMigrationSpeed; // Added metric

    public Metrics(long activeUsers, double systemHealth, int deploymentFrequency, double errorRate,
            double cloudMigrationSpeed) {
        this.activeUsers = activeUsers;
        this.systemHealth = systemHealth;
        this.deploymentFrequency = deploymentFrequency;
        this.errorRate = errorRate;
        this.cloudMigrationSpeed = cloudMigrationSpeed;
    }

    // Getters and Setters
    public long getActiveUsers() {
        return activeUsers;
    }

    public void setActiveUsers(long activeUsers) {
        this.activeUsers = activeUsers;
    }

    public double getSystemHealth() {
        return systemHealth;
    }

    public void setSystemHealth(double systemHealth) {
        this.systemHealth = systemHealth;
    }

    public int getDeploymentFrequency() {
        return deploymentFrequency;
    }

    public void setDeploymentFrequency(int deploymentFrequency) {
        this.deploymentFrequency = deploymentFrequency;
    }

    public double getErrorRate() {
        return errorRate;
    }

    public void setErrorRate(double errorRate) {
        this.errorRate = errorRate;
    }

    public double getCloudMigrationSpeed() {
        return cloudMigrationSpeed;
    }

    public void setCloudMigrationSpeed(double cloudMigrationSpeed) {
        this.cloudMigrationSpeed = cloudMigrationSpeed;
    }
}
