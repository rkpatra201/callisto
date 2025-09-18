package org.lld.examples.locker.handler.impl;

import org.lld.examples.locker.dao.BookingDao;
import org.lld.examples.locker.dao.LockerDao;
import org.lld.examples.locker.model.ItemPackage;
import org.lld.examples.locker.model.Locker;
import org.lld.examples.locker.model.Slot;
import org.lld.examples.locker.model.SlotBooking;
import org.lld.examples.locker.handler.CourierPackageHandler;
import org.lld.examples.locker.service.MessageService;
import org.lld.examples.locker.service.OtpService;

/**
 * Implementation of {@link CourierPackageHandler} for handling package operations performed by a courier.
 */
public class CourierPackageHandlerImpl implements CourierPackageHandler {

    private final OtpService otpService;
    private final MessageService messageService;
    private final BookingDao bookingDao;
    private final PackageHandlerHelper helper;

    /**
     * Constructs a new CourierPackageHandlerImpl.
     *
     * @param otpService     The service for generating OTPs.
     * @param messageService The service for sending notifications.
     * @param bookingDao     The data access object for bookings.
     * @param lockerDao      The data access object for lockers.
     */
    public CourierPackageHandlerImpl(OtpService otpService, MessageService messageService, BookingDao bookingDao, LockerDao lockerDao) {
        this.otpService = otpService;
        this.messageService = messageService;
        this.bookingDao = bookingDao;
        this.helper = new PackageHandlerHelper(lockerDao, bookingDao);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void createSlotBooking(String lockerId, ItemPackage itemPackage) {
        Locker locker = helper.getLockerOrThrow(lockerId);
        Slot slot = helper.findAvailableSlot(locker, itemPackage.getSize());

        String otp = otpService.generateOtp();
        SlotBooking slotBooking = new SlotBooking(slot, otp, itemPackage);
        bookingDao.save(slotBooking);

        messageService.sendOtpOnAssign(itemPackage.getOrderId(), otp, "courier");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deliverPackage(String orderId, String otp) {
        SlotBooking slotBooking = helper.getBookingOrThrow(orderId);
        helper.validateOtpOrThrow(slotBooking, otp);

        slotBooking.getSlot().setStatus(org.lld.examples.locker.model.SlotStatus.OCCUPIED);

        String newOtp = otpService.generateOtp();
        slotBooking.setOtp(newOtp);

        ItemPackage pkg = slotBooking.getItemPackage();
        messageService.sendOtpOnAssign(pkg.getOrderId(), newOtp, pkg.getCustomerId());
        messageService.onOrderDelivered(pkg.getOrderId(), pkg.getCustomerId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void pickUpReturn(String orderId, String otp) {
        SlotBooking slotBooking = helper.getBookingOrThrow(orderId);
        helper.validateOtpOrThrow(slotBooking, otp);

        slotBooking.getSlot().setStatus(org.lld.examples.locker.model.SlotStatus.EMPTY);

        ItemPackage pkg = slotBooking.getItemPackage();
        messageService.onReturnPickedUp(pkg.getOrderId(), pkg.getCustomerId());
    }
}
