package com.example.tourismappv20;

public class Attraction {
    public static final double ZOO_FEE = 10.95;
    public static final double PACSCI_FEE = 25.95;
    public static final double CEDAR_POINT_FEE = 45.99;

    private int attractionName;
    private int description;
    private int fees;
    private int hours;
    private int image;
    private double feeAmount;

    public Attraction(int attractionName, int description, int fees, int hours, int image) {
        this.attractionName = attractionName;
        this.description = description;
        this.fees = fees;
        this.hours = hours;
        this.image = image;
    }

    public int getAttractionName() {
        return attractionName;
    }

    public int getDescription() {
        return description;
    }

    public int getFees() {
        return fees;
    }

    public int getHours() {
        return hours;
    }

    public int getImage() {
        return image;
    }

    public void setAttractionName(int attractionName) {
        this.attractionName = attractionName;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

