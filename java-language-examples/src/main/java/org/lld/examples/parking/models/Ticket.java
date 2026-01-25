package org.lld.examples.parking.models;

import org.lld.examples.parking.enums.TicketStatus;
import org.lld.examples.parking.services.pricing.PricingStrategy;
import java.time.LocalDateTime;

public class Ticket {
    private String id;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private TicketStatus status;
    private final PricingStrategy pricingStrategy;

    public Ticket(String id, LocalDateTime entryTime, Vehicle vehicle, ParkingSpot parkingSpot, PricingStrategy pricingStrategy) {
        this.id = id;
        this.entryTime = entryTime;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.status = TicketStatus.ACTIVE;
        this.pricingStrategy = pricingStrategy;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public PricingStrategy getPricingStrategy() {
        return pricingStrategy;
    }
}
