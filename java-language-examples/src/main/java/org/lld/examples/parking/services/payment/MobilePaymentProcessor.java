package org.lld.examples.parking.services.payment;

import org.lld.examples.parking.models.Ticket;

public class MobilePaymentProcessor implements PaymentProcessor {
    @Override
    public boolean processPayment(double amount, Ticket ticket) {
        System.out.println("Processing mobile payment (UPI/QR) of " + amount + " for ticket " + ticket.getId());
        // In a real system, this would integrate with a mobile payment gateway
        return true;
    }
}
