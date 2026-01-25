package org.lld.examples.parking.models;

public class Gate {
    private int id;
    private GateType type;

    public Gate(int id, GateType type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public GateType getType() {
        return type;
    }

    public void open() {
        System.out.println("Gate " + id + " opened.");
    }

    public void close() {
        System.out.println("Gate " + id + " closed.");
    }
}
