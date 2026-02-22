package org.lld.examples.parking.services;

import org.lld.examples.parking.models.Ticket;
import org.lld.examples.parking.models.Vehicle;
import org.lld.examples.parking.models.ParkingSpot;
import org.lld.examples.parking.services.pricing.PricingStrategy;
import java.time.LocalDateTime;
import java.util.UUID;

public class TicketService {

    public Ticket createTicket(Vehicle vehicle, ParkingSpot parkingSpot, PricingStrategy pricingStrategy) {
        String ticketId = UUID.randomUUID().toString();
        LocalDateTime entryTime = LocalDateTime.now();
        return new Ticket(ticketId, entryTime, vehicle, parkingSpot, pricingStrategy);
    }
}
