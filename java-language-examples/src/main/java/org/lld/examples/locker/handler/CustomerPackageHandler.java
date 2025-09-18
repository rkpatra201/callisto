package org.lld.examples.locker.handler;

import org.lld.examples.locker.service.PackageHandler;

public interface CustomerPackageHandler extends PackageHandler {
    void pickUpPackage(String orderId, String otp);
    String initiateReturn(String orderId, String lockerId);
    void dropOffReturn(String orderId, String otp);
}
