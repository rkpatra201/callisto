package org.lld.examples.parking.services.payment;

import org.lld.examples.parking.models.Ticket;

public interface PaymentProcessor {
    boolean processPayment(double amount, Ticket ticket);
}
