package org.lld.examples.locker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Slot {
    private String slotId;
    private int slotNum;
    private SlotStatus status;
    private Size size;
    private Locker locker;
}
