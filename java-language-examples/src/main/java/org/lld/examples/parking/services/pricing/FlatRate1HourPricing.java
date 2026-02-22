package org.lld.examples.parking.services.pricing;

import org.lld.examples.parking.models.Ticket;
import java.time.Duration;
import java.time.LocalDateTime;

public class FlatRate1HourPricing implements PricingStrategy {

    private static final double HOURLY_RATE = 5.0;

    @Override
    public double calculateFee(Ticket ticket) {
        LocalDateTime entryTime = ticket.getEntryTime();
        LocalDateTime exitTime = LocalDateTime.now();
        ticket.setExitTime(exitTime);

        Duration duration = Duration.between(entryTime, exitTime);
        long hours = duration.toHours();
        if (duration.toMinutesPart() > 0) {
            hours++;
        }
        
        if (hours == 0) {
            return HOURLY_RATE;
        }

        return hours * HOURLY_RATE;
    }
}
