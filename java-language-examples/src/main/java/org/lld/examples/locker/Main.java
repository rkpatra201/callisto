package org.lld.examples.locker;

import org.lld.examples.locker.dao.BookingDao;
import org.lld.examples.locker.dao.LockerDao;
import org.lld.examples.locker.dao.impl.BookingDaoImpl;
import org.lld.examples.locker.dao.impl.LockerDaoImpl;
import org.lld.examples.locker.exception.InvalidOtpException;
import org.lld.examples.locker.exception.SlotNotFoundException;
import org.lld.examples.locker.model.ItemPackage;
import org.lld.examples.locker.model.Locker;
import org.lld.examples.locker.model.Size;
import org.lld.examples.locker.notification.MobileNotifier;
import org.lld.examples.locker.notification.NotificationSender;
import org.lld.examples.locker.handler.CourierPackageHandler;
import org.lld.examples.locker.handler.CustomerPackageHandler;
import org.lld.examples.locker.service.LockerSetupService;
import org.lld.examples.locker.service.MessageService;
import org.lld.examples.locker.service.OtpService;
import org.lld.examples.locker.handler.impl.CourierPackageHandlerImpl;
import org.lld.examples.locker.handler.impl.CustomerPackageHandlerImpl;
import org.lld.examples.locker.service.impl.LockerSetupServiceImpl;
import org.lld.examples.locker.service.impl.OtpServiceImpl;

public class Main {
    public static void main(String[] args) {
        // Initialize dependencies
        LockerDao lockerDao = new LockerDaoImpl();
        BookingDao bookingDao = new BookingDaoImpl();
        OtpService otpService = new OtpServiceImpl();
        NotificationSender notificationSender = new MobileNotifier();
        MessageService messageService = new MessageService(notificationSender);

        // Create the new actor-based services
        LockerSetupService lockerSetupService = new LockerSetupServiceImpl(lockerDao);
        CustomerPackageHandler customerHandler = new CustomerPackageHandlerImpl(otpService, messageService, bookingDao, lockerDao);
        CourierPackageHandler courierHandler = new CourierPackageHandlerImpl(otpService, messageService, bookingDao, lockerDao);

        // Create a locker and add slots
        Locker locker = lockerSetupService.createLocker("Locker1");
        lockerSetupService.addSlots(locker, 1, Size.MEDIUM); // Only 1 slot to test slot not found

        System.out.println("--- Starting Locker Service Dry Run ---");

        // --- Happy Path Scenario ---
        System.out.println();
        System.out.println("--- Scenario 1: Happy Path ---");
        runHappyPath(customerHandler, courierHandler, bookingDao, locker);

        // --- Error Scenarios ---
        System.out.println();
        System.out.println("--- Scenario 2: Error Scenarios ---");
        runErrorScenarios(customerHandler, courierHandler, bookingDao, locker);

        System.out.println();
        System.out.println("--- Locker Service Dry Run Complete ---");
    }

    private static void runHappyPath(CustomerPackageHandler customerHandler, CourierPackageHandler courierHandler, BookingDao bookingDao, Locker locker) {
        try {
            System.out.println("1. Customer places an order.");
            ItemPackage itemPackage = new ItemPackage();
            itemPackage.setOrderId("Order123");
            itemPackage.setCustomerId("Customer1");
            itemPackage.setSize(Size.MEDIUM);

            System.out.println("2. Courier is assigned to deliver the order.");
            courierHandler.createSlotBooking(locker.getLockerId(), itemPackage);

            System.out.println("3. Courier delivers the order to the locker.");
            String deliveryOtp = bookingDao.findById(itemPackage.getOrderId()).getOtp();
            courierHandler.deliverPackage(itemPackage.getOrderId(), deliveryOtp);

            System.out.println("4. Customer picks up the order from the locker.");
            String customerOtp = bookingDao.findById(itemPackage.getOrderId()).getOtp();
            customerHandler.pickUpPackage(itemPackage.getOrderId(), customerOtp);

            System.out.println("Happy Path (Delivery & Pickup): SUCCESS");

        } catch (Exception e) {
            System.out.println("Happy Path Scenario: FAILED with exception - " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void runErrorScenarios(CustomerPackageHandler customerHandler, CourierPackageHandler courierHandler, BookingDao bookingDao, Locker locker) {
        // --- Invalid OTP ---
        try {
            System.out.println();
            System.out.println("- Testing: Customer tries to pick up with wrong OTP.");
            ItemPackage itemPackageForOtpTest = new ItemPackage();
            itemPackageForOtpTest.setOrderId("Order789");
            itemPackageForOtpTest.setCustomerId("Customer3");
            itemPackageForOtpTest.setSize(Size.MEDIUM);
            courierHandler.createSlotBooking(locker.getLockerId(), itemPackageForOtpTest);
            String deliveryOtp = bookingDao.findById(itemPackageForOtpTest.getOrderId()).getOtp();
            courierHandler.deliverPackage(itemPackageForOtpTest.getOrderId(), deliveryOtp);

            customerHandler.pickUpPackage(itemPackageForOtpTest.getOrderId(), "WRONG_OTP");
        } catch (InvalidOtpException e) {
            System.out.println("  SUCCESS: Caught expected exception - " + e.getMessage());
        } catch (Exception e) {
            System.out.println("  FAILED: Caught unexpected exception - " + e.getMessage());
        }

        // --- Slot Not Found ---
        try {
            System.out.println();
            System.out.println("- Testing: Courier tries to book a slot when locker is full.");
            ItemPackage itemPackageForSlotTest = new ItemPackage();
            itemPackageForSlotTest.setOrderId("Order456");
            itemPackageForSlotTest.setCustomerId("Customer2");
            itemPackageForSlotTest.setSize(Size.MEDIUM);
            courierHandler.createSlotBooking(locker.getLockerId(), itemPackageForSlotTest);
        } catch (SlotNotFoundException e) {
            System.out.println("  SUCCESS: Caught expected exception - " + e.getMessage());
        } catch (Exception e) {
            System.out.println("  FAILED: Caught unexpected exception - " + e.getMessage());
        }
    }
}
