package org.lld.examples.parking.services.payment;

import org.lld.examples.parking.models.Ticket;

public class CreditCardPaymentProcessor implements PaymentProcessor {
    @Override
    public boolean processPayment(double amount, Ticket ticket) {
        System.out.println("Processing credit card payment of " + amount + " for ticket " + ticket.getId());
        // In a real system, this would integrate with a credit card gateway
        return true;
    }
}
