package org.lld.examples.locker.service;

import org.lld.examples.locker.notification.NotificationSender;

public class MessageService {

    private final NotificationSender notifier;

    public MessageService(NotificationSender notifier) {
        this.notifier = notifier;
    }

    public void sendOtpOnAssign(String orderId, String otp, String recipient){
        System.out.println("Sending OTP "+otp+" for order "+orderId+" to recipient "+recipient);
        String message = "Your OTP for order "+orderId+" is "+otp;
        notifier.notify(recipient, message);
    }

    public void onOrderDelivered(String orderId, String recipient){
        System.out.println("Notifying order delivery for order "+orderId+" to recipient "+recipient);
        String message = "Your order "+orderId+" has been delivered to the locker. Please pick it up within 24 hours.";
        notifier.notify(recipient, message);
    }

    public void onOrderPickedUp(String orderId, String recipient){
        System.out.println("Notifying order pickup for order "+orderId+" to recipient "+recipient);
        String message = "Your order "+orderId+" has been picked up from the locker. Thank you!";
        notifier.notify(recipient, message);
    }

    public void onOrderReturned(String orderId, String recipient) {
        System.out.println("Notifying order return for order " + orderId + " to recipient " + recipient);
        String message = "Your order " + orderId + " has been returned to the locker. A courier will pick it up shortly.";
        notifier.notify(recipient, message);
    }

    public void onReturnPickedUp(String orderId, String recipient) {
        System.out.println("Notifying return pickup for order " + orderId + " to recipient " + recipient);
        String message = "Your returned order " + orderId + " has been picked up from the locker.";
        notifier.notify(recipient, message);
    }
}