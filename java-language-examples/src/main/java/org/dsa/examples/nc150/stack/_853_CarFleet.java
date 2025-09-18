package org.dsa.examples.nc150.stack;

public class _853_CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i]; // calculate time to reach target
        }
        // sort cars by position
        java.util.Arrays.sort(cars, (car1, car2) -> Double.compare(car2[0], car1[0]));
        int fleets = 0;
        double lastTime = 0;
        for (int i = 0; i < n; i++) {
            if (cars[i][1] > lastTime) {
                fleets++;
                lastTime = cars[i][1];
            }
        }
        return fleets;
    }
}
