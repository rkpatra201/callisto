package org.lld.examples.locker.service.impl;

import org.lld.examples.locker.dao.LockerDao;
import org.lld.examples.locker.model.Locker;
import org.lld.examples.locker.model.Size;
import org.lld.examples.locker.model.Slot;
import org.lld.examples.locker.model.SlotStatus;
import org.lld.examples.locker.service.LockerSetupService;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Implementation of {@link LockerSetupService} for administrative tasks related to locker setup.
 */
public class LockerSetupServiceImpl implements LockerSetupService {

    private final LockerDao lockerDao;

    /**
     * Constructs a new LockerSetupServiceImpl.
     *
     * @param lockerDao The data access object for lockers.
     */
    public LockerSetupServiceImpl(LockerDao lockerDao) {
        this.lockerDao = lockerDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Locker createLocker(String lockerId) {
        Locker locker = new Locker();
        locker.setLockerId(lockerId);
        locker.setSlots(new ArrayList<>());
        return lockerDao.save(locker);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addSlots(Locker locker, int num, Size size) {
        for (int i = 0; i < num; i++) {
            Slot slot = new Slot(UUID.randomUUID().toString(), i + 1, SlotStatus.EMPTY, size, locker);
            locker.getSlots().add(slot);
        }
    }
}
