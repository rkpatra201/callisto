package org.dsa.examples.nc150.binarysearch;

class _875_KokoEatingBanana {
    public int minEatingSpeed(int[] piles, int h) {
        int max = -1;
        for (int i : piles) {
            max = Math.max(i, max);
        }
        int start = 1; // minSpeed = 1 banana per hour
        int end = max; // maxSpeed = max banana per hour

        // if speed reduced we may need more hours > h
        // if speed increased we may need less hours < h
        // requirement is to find min speed

        // do binary search over speed range of start and end, and check which speed is best

        int ans = end; // why?

        while (start <= end) {

            int speed = start + (end - start) / 2;

            if (canFinish(piles, speed, h)) { // if you can finish with this speed, try to find smaller speed
                ans = speed;
                end = speed - 1;
            } else { // if you cannot finish with this speed, try to find larger speed
                start = speed + 1;
            }

        }

        return ans;
    }
    private boolean canFinish(int[] piles, int speed, int h) {
        /**
         * ceil(1) = 1
         * ceil(1.1) = 2
         * ceil(1.9) = 2
         * ceil(2) = 2
         */
        int hoursNeeded = 0;
        for (int pile : piles) {
            hoursNeeded += Math.ceil((double) pile / speed);
        }
        return hoursNeeded <= h;
    }
}