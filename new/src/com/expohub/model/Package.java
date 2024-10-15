package com.expohub.model;

public class Package {
    private int packageId;
    private String packageName;
    private String details;
    private double price;

    // Constructor
    public Package(int packageId, String packageName, String details, double price) {
        this.packageId = packageId;
        this.packageName = packageName;
        this.details = details;
        this.price = price;
    }

    // Getters and Setters
    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
