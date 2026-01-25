package org.lld.examples.parking.models;

public class SpotStatus {
    private long occupied;
    private long available;
    private long total;

    public SpotStatus(long occupied, long available, long total) {
        this.occupied = occupied;
        this.available = available;
        this.total = total;
    }

    public long getOccupied() {
        return occupied;
    }

    public long getAvailable() {
        return available;
    }



    public long getTotal() {
        return total;
    }
}
