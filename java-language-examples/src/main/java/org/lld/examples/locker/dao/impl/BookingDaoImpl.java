package org.lld.examples.locker.dao.impl;

import org.lld.examples.locker.dao.BookingDao;
import org.lld.examples.locker.model.SlotBooking;

import java.util.HashMap;
import java.util.Map;

public class BookingDaoImpl implements BookingDao {

    private Map<String, SlotBooking> slotBookingStore = new HashMap<>();

    @Override
    public void save(SlotBooking slotBooking) {
        slotBookingStore.put(slotBooking.getBookingId(), slotBooking);
    }

    @Override
    public SlotBooking findById(String id) {
        return slotBookingStore.get(id);
    }
}
