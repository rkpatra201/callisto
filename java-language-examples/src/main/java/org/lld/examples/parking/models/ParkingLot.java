package org.lld.examples.parking.models;

import java.util.List;

public class ParkingLot {
    private String name;
    private List<Floor> floors;

    public ParkingLot(String name, List<Floor> floors) {
        this.name = name;
        this.floors = floors;
    }

    public String getName() {
        return name;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public Floor getFloorForParkingSpotId(int parkingSpotId) {
        for (Floor floor : floors) {
            for (ParkingSpot spot : floor.getParkingSpots()) {
                if (spot.getId() == parkingSpotId) {
                    return floor;
                }
            }
        }
        return null; // Or throw an exception if the spot is not found
    }
}
