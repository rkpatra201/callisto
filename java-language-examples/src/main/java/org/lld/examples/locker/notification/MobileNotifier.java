package org.lld.examples.locker.notification;

public class MobileNotifier implements NotificationSender{
    @Override
    public void notify(String recipient, String message) {
        System.out.println("Sending OTP to " + recipient + ": " + message);
    }
}
