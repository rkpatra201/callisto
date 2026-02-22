package org.lld.examples.parking.services;

import org.lld.examples.parking.models.Ticket;
import org.lld.examples.parking.models.Payment;
import org.lld.examples.parking.enums.PaymentMode;
import org.lld.examples.parking.services.payment.PaymentProcessor;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public class PaymentService {

    private final Map<PaymentMode, PaymentProcessor> paymentProcessors;

    public PaymentService(Map<PaymentMode, PaymentProcessor> paymentProcessors) {
        this.paymentProcessors = paymentProcessors;
    }

    public double calculateFee(Ticket ticket) {
        return ticket.getPricingStrategy().calculateFee(ticket);
    }

    public Payment processPayment(Ticket ticket, PaymentMode paymentMode) {
        double amount = calculateFee(ticket);

        PaymentProcessor processor = paymentProcessors.get(paymentMode);
        if (processor == null) {
            throw new IllegalArgumentException("No payment processor found for mode: " + paymentMode);
        }

        if (!processor.processPayment(amount, ticket)) {
            throw new RuntimeException("Payment processing failed for ticket: " + ticket.getId());
        }

        String paymentId = UUID.randomUUID().toString();
        LocalDateTime paymentTime = LocalDateTime.now();
        return new Payment(paymentId, ticket, amount, paymentTime, paymentMode);
    }
}
