package org.lld.examples.locker.dao;

import org.lld.examples.locker.model.SlotBooking;

public interface BookingDao {
    void save(SlotBooking slotBooking);
    SlotBooking findById(String id);
}
