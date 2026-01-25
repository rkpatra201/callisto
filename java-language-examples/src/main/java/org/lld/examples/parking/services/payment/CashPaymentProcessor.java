package org.lld.examples.parking.services.payment;

import org.lld.examples.parking.models.Ticket;

public class CashPaymentProcessor implements PaymentProcessor {
    @Override
    public boolean processPayment(double amount, Ticket ticket) {
        System.out.println("Processing cash payment of " + amount + " for ticket " + ticket.getId());
        // In a real system, this would involve recording cash receipt
        return true;
    }
}
