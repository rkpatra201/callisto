package org.lld.examples.parking.models;

import org.lld.examples.parking.enums.ParkingSpotType;

public class ParkingSpot {
    private int id;
    private ParkingSpotType spotType;
    private boolean isAvailable;
    private Vehicle vehicle;

    public ParkingSpot(int id, ParkingSpotType spotType) {
        this.id = id;
        this.spotType = spotType;
        this.isAvailable = true;
    }

    public int getId() {
        return id;
    }

    public ParkingSpotType getSpotType() {
        return spotType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isAvailable = false;
    }

    public void unparkVehicle() {
        this.vehicle = null;
        this.isAvailable = true;
    }
}
