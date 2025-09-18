package org.lld.examples.locker.handler.impl;

import org.lld.examples.locker.dao.BookingDao;
import org.lld.examples.locker.dao.LockerDao;
import org.lld.examples.locker.exception.BookingNotFoundException;
import org.lld.examples.locker.exception.InvalidOtpException;
import org.lld.examples.locker.exception.LockerNotFoundException;
import org.lld.examples.locker.exception.SlotNotFoundException;
import org.lld.examples.locker.model.Locker;
import org.lld.examples.locker.model.Size;
import org.lld.examples.locker.model.Slot;
import org.lld.examples.locker.model.SlotBooking;
import org.lld.examples.locker.model.SlotStatus;

/**
 * A helper class that contains common logic shared between different package handler implementations.
 * This includes common validation and data retrieval operations.
 */
public class PackageHandlerHelper {

    private final LockerDao lockerDao;
    private final BookingDao bookingDao;

    /**
     * Constructs a new PackageHandlerHelper.
     *
     * @param lockerDao The data access object for lockers.
     * @param bookingDao The data access object for bookings.
     */
    public PackageHandlerHelper(LockerDao lockerDao, BookingDao bookingDao) {
        this.lockerDao = lockerDao;
        this.bookingDao = bookingDao;
    }

    /**
     * Retrieves a locker by its ID or throws an exception if not found.
     *
     * @param lockerId The ID of the locker to retrieve.
     * @return The found Locker.
     * @throws LockerNotFoundException if the locker is not found.
     */
    public Locker getLockerOrThrow(String lockerId) {
        Locker locker = lockerDao.findById(lockerId);
        if (locker == null) {
            throw new LockerNotFoundException("Invalid lockerId: " + lockerId);
        }
        return locker;
    }

    /**
     * Retrieves a booking by its order ID or throws an exception if not found.
     *
     * @param orderId The order ID of the booking to retrieve.
     * @return The found SlotBooking.
     * @throws BookingNotFoundException if the booking is not found.
     */
    public SlotBooking getBookingOrThrow(String orderId) {
        SlotBooking booking = bookingDao.findById(orderId);
        if (booking == null) {
            throw new BookingNotFoundException("Invalid orderId: " + orderId);
        }
        return booking;
    }

    /**
     * Validates the provided OTP for a booking.
     *
     * @param booking The booking to validate the OTP against.
     * @param otp The OTP to validate.
     * @throws InvalidOtpException if the OTP is invalid.
     */
    public void validateOtpOrThrow(SlotBooking booking, String otp) {
        if (!booking.getOtp().equals(otp)) {
            throw new InvalidOtpException("Invalid otp");
        }
    }

    /**
     * Finds an available slot of a given size in a locker.
     *
     * @param locker The locker to search for an available slot.
     * @param size The size of the slot to find.
     * @return The found available Slot.
     * @throws SlotNotFoundException if no available slot is found.
     */
    public Slot findAvailableSlot(Locker locker, Size size) {
        return locker.getSlots().stream()
                .filter(slot -> slot.getSize() == size && slot.getStatus() == SlotStatus.EMPTY)
                .findFirst()
                .orElseThrow(() -> new SlotNotFoundException("No slot available"));
    }
}
