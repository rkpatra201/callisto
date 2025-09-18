package org.lld.examples.locker.service;

import org.lld.examples.locker.model.ItemPackage;
import org.lld.examples.locker.model.Role;

public interface LockerBookingService {
    void initiateDelivery(String lockerId, ItemPackage itemPackage, Role actorRole);

    String initiateReturn(String orderId, String lockerId, Role actorRole);
}
