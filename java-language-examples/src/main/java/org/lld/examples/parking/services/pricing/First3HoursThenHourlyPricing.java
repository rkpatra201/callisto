package org.lld.examples.parking.services.pricing;

import org.lld.examples.parking.models.Ticket;
import java.time.Duration;
import java.time.LocalDateTime;

public class First3HoursThenHourlyPricing implements PricingStrategy {

    private static final double FIRST_3_HOURS_RATE = 15.0;
    private static final double ADDITIONAL_HOURLY_RATE = 4.0;

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

        if (hours <= 3) {
            return FIRST_3_HOURS_RATE;
        } else {
            return FIRST_3_HOURS_RATE + (hours - 3) * ADDITIONAL_HOURLY_RATE;
        }
    }
}
