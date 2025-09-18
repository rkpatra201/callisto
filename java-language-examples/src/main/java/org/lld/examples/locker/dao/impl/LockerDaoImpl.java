package org.lld.examples.locker.dao.impl;

import org.lld.examples.locker.dao.LockerDao;
import org.lld.examples.locker.model.Locker;

import java.util.HashMap;
import java.util.Map;

public class LockerDaoImpl implements LockerDao {

    private Map<String, Locker> lockerStore = new HashMap<>();

    @Override
    public Locker findById(String id) {
        return lockerStore.get(id);
    }

    @Override
    public Locker save(Locker locker) {
        lockerStore.put(locker.getLockerId(), locker);
        return locker;
    }
}
