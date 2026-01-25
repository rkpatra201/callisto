package org.lld.examples.parking.models;

import org.lld.examples.parking.enums.ParkingSpotType;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Floor {
    private int floorNumber;
    private List<ParkingSpot> parkingSpots;

    public Floor(int floorNumber, List<ParkingSpot> parkingSpots) {
        this.floorNumber = floorNumber;
        this.parkingSpots = parkingSpots;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public long getNumberOfAvailableSpots() {
        return parkingSpots.stream().filter(ParkingSpot::isAvailable).count();
    }

    public long getNumberOfOccupiedSpots() {
        return parkingSpots.stream().filter(spot -> !spot.isAvailable()).count();
    }

    public long getNumberOfAvailableSpots(ParkingSpotType spotType) {
        return parkingSpots.stream()
                .filter(spot -> spot.getSpotType() == spotType && spot.isAvailable())
                .count();
    }

    public long getNumberOfOccupiedSpots(ParkingSpotType spotType) {
        return parkingSpots.stream()
                .filter(spot -> spot.getSpotType() == spotType && !spot.isAvailable())
                .count();
    }

    public Map<ParkingSpotType, SpotStatus> getSpotStatusSummary() {
        return parkingSpots.stream()
                .collect(Collectors.groupingBy(
                        ParkingSpot::getSpotType,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                spots -> {
                                    long occupied = spots.stream().filter(spot -> !spot.isAvailable()).count();
                                    long available = spots.stream().filter(ParkingSpot::isAvailable).count();
                                    long total = spots.size();
                                    return new SpotStatus(occupied, available, total);
                                }
                        )
                ));
    }
}
