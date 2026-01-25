package org.lld.examples.parking.services.pricing;

import org.lld.examples.parking.models.Ticket;
import java.time.Duration;
import java.time.LocalDateTime;

public class FlatRate12HourPricing implements PricingStrategy {

    private static final double RATE_PER_12_HOURS = 20.0;

    @Override
    public double calculateFee(Ticket ticket) {
        LocalDateTime entryTime = ticket.getEntryTime();
        LocalDateTime exitTime = LocalDateTime.now();
        ticket.setExitTime(exitTime);

        Duration duration = Duration.between(entryTime, exitTime);
        long hours = duration.toHours();
        long numberOf12HourBlocks = (hours + 11) / 12; // Ceiling division

        if (numberOf12HourBlocks == 0) {
            numberOf12HourBlocks = 1;
        }

        return numberOf12HourBlocks * RATE_PER_12_HOURS;
    }
}
