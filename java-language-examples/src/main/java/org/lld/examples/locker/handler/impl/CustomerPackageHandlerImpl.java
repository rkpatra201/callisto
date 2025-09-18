package org.lld.examples.locker.handler.impl;

import org.lld.examples.locker.dao.BookingDao;
import org.lld.examples.locker.dao.LockerDao;
import org.lld.examples.locker.model.ItemPackage;
import org.lld.examples.locker.model.Locker;
import org.lld.examples.locker.model.Slot;
import org.lld.examples.locker.model.SlotBooking;
import org.lld.examples.locker.handler.CustomerPackageHandler;
import org.lld.examples.locker.service.MessageService;
import org.lld.examples.locker.service.OtpService;

/**
 * Implementation of {@link CustomerPackageHandler} for handling package operations performed by a customer.
 */
public class CustomerPackageHandlerImpl implements CustomerPackageHandler {

    private final OtpService otpService;
    private final MessageService messageService;
    private final BookingDao bookingDao;
    private final PackageHandlerHelper helper;

    /**
     * Constructs a new CustomerPackageHandlerImpl.
     *
     * @param otpService     The service for generating OTPs.
     * @param messageService The service for sending notifications.
     * @param bookingDao     The data access object for bookings.
     * @param lockerDao      The data access object for lockers.
     */
    public CustomerPackageHandlerImpl(OtpService otpService, MessageService messageService, BookingDao bookingDao, LockerDao lockerDao) {
        this.otpService = otpService;
        this.messageService = messageService;
        this.bookingDao = bookingDao;
        this.helper = new PackageHandlerHelper(lockerDao, bookingDao);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void pickUpPackage(String orderId, String otp) {
        SlotBooking slotBooking = helper.getBookingOrThrow(orderId);
        helper.validateOtpOrThrow(slotBooking, otp);

        slotBooking.getSlot().setStatus(org.lld.examples.locker.model.SlotStatus.EMPTY);

        ItemPackage pkg = slotBooking.getItemPackage();
        messageService.onOrderPickedUp(pkg.getOrderId(), pkg.getCustomerId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String initiateReturn(String orderId, String lockerId) {
        Locker locker = helper.getLockerOrThrow(lockerId);
        SlotBooking slotBooking = helper.getBookingOrThrow(orderId);

        Slot slot = helper.findAvailableSlot(locker, slotBooking.getItemPackage().getSize());

        String otp = otpService.generateOtp();
        slotBooking.setSlot(slot);
        slotBooking.setOtp(otp);

        messageService.sendOtpOnAssign(orderId, otp, slotBooking.getItemPackage().getCustomerId());
        return otp;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void dropOffReturn(String orderId, String otp) {
        SlotBooking slotBooking = helper.getBookingOrThrow(orderId);
        helper.validateOtpOrThrow(slotBooking, otp);

        slotBooking.getSlot().setStatus(org.lld.examples.locker.model.SlotStatus.OCCUPIED);

        String newOtp = otpService.generateOtp();
        slotBooking.setOtp(newOtp);

        ItemPackage pkg = slotBooking.getItemPackage();
        messageService.sendOtpOnAssign(pkg.getOrderId(), newOtp, "courier");
        messageService.onOrderReturned(pkg.getOrderId(), "courier");
    }
}
