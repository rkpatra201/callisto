package org.lld.examples.parking.services;

import org.lld.examples.parking.models.*;
import org.lld.examples.parking.enums.ParkingSpotType;
import org.lld.examples.parking.enums.VehicleType;
import org.lld.examples.parking.enums.PaymentMode;
import org.lld.examples.parking.enums.TicketStatus;
import org.lld.examples.parking.services.pricing.FlatRate12HourPricing;

public class ParkingService {

    private final ParkingLot parkingLot;
    private final TicketService ticketService;
    private final PaymentService paymentService;

    public ParkingService(ParkingLot parkingLot, TicketService ticketService, PaymentService paymentService) {
        this.parkingLot = parkingLot;
        this.ticketService = ticketService;
        this.paymentService = paymentService;
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        ParkingSpot parkingSpot = findAvailableSpot(vehicle.getType());
        if (parkingSpot == null) {
            throw new IllegalStateException("No available parking spot for " + vehicle.getType());
        }

        parkingSpot.parkVehicle(vehicle);
        return ticketService.createTicket(vehicle, parkingSpot, new FlatRate12HourPricing());
    }

    public Payment unparkVehicle(Ticket ticket, PaymentMode paymentMode) {
        Payment payment = paymentService.processPayment(ticket, paymentMode);
        ticket.setStatus(TicketStatus.PAID);

        ParkingSpot parkingSpot = ticket.getParkingSpot();
        parkingSpot.unparkVehicle();

        return payment;
    }

    private ParkingSpot findAvailableSpot(VehicleType vehicleType) {
        ParkingSpotType requiredSpotType = getSpotTypeForVehicle(vehicleType);
        for (Floor floor : parkingLot.getFloors()) {
            for (ParkingSpot spot : floor.getParkingSpots()) {
                if (spot.getSpotType() == requiredSpotType && spot.isAvailable()) {
                    return spot;
                }
            }
        }
        return null;
    }

    private ParkingSpotType getSpotTypeForVehicle(VehicleType vehicleType) {
        switch (vehicleType) {
            case MOTORCYCLE:
                return ParkingSpotType.SMALL;
            case CAR:
                return ParkingSpotType.MEDIUM;
            case TRUCK:
                return ParkingSpotType.LARGE;
            default:
                throw new IllegalArgumentException("Unsupported vehicle type: " + vehicleType);
        }
    }
}
