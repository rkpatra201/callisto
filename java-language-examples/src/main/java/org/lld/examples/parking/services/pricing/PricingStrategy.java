package org.lld.examples.parking.services.pricing;

import org.lld.examples.parking.models.Ticket;

public interface PricingStrategy {
    double calculateFee(Ticket ticket);
}
