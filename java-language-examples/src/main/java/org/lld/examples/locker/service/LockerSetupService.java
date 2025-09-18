package org.lld.examples.locker.service;

import org.lld.examples.locker.model.Locker;
import org.lld.examples.locker.model.Size;

public interface LockerSetupService {
    Locker createLocker(String lockerId);
    void addSlots(Locker locker, int num, Size size);
}
