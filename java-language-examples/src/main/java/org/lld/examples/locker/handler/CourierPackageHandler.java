package org.lld.examples.locker.handler;

import org.lld.examples.locker.model.ItemPackage;
import org.lld.examples.locker.service.PackageHandler;

public interface CourierPackageHandler extends PackageHandler {
    void createSlotBooking(String lockerId, ItemPackage itemPackage);
    void deliverPackage(String orderId, String otp);
    void pickUpReturn(String orderId, String otp);
}
