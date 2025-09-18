package org.lld.examples.locker.dao;

import org.lld.examples.locker.model.Locker;

public interface LockerDao {
    Locker findById(String id);
    Locker save(Locker locker);
}
