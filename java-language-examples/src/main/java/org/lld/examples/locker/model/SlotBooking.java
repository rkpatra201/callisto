package org.lld.examples.locker.model;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class SlotBooking {
    private String bookingId;
    private LocalDateTime localDateTime;
    private Slot slot;
    private String otp;
    private ItemPackage itemPackage;

    public SlotBooking(Slot slot, String otp, ItemPackage itemPackage) {
        this.bookingId = itemPackage.getOrderId();
        this.localDateTime = Instant.now().atZone(java.time.ZoneId.systemDefault()).toLocalDateTime();
        this.slot = slot;
        this.otp = otp;
        this.itemPackage = itemPackage;
    }
}
