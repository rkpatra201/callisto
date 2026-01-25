package org.lld.examples.parking.models;

import org.lld.examples.parking.enums.VehicleType;

public class Car extends Vehicle {
    public Car(String licensePlate) {
        super(licensePlate, VehicleType.CAR);
    }
}
