package org.lld.examples.parking.models;

import org.lld.examples.parking.enums.PaymentMode;
import java.time.LocalDateTime;

public class Payment {
    private String id;
    private Ticket ticket;
    private double amount;
    private LocalDateTime paymentTime;
    private PaymentMode paymentMode;

    public Payment(String id, Ticket ticket, double amount, LocalDateTime paymentTime, PaymentMode paymentMode) {
        this.id = id;
        this.ticket = ticket;
        this.amount = amount;
        this.paymentTime = paymentTime;
        this.paymentMode = paymentMode;
    }

    public String getId() {
        return id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }
}
