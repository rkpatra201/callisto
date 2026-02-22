package org.dsa.examples.nc150.binarysearch;

import java.util.*;

class _981_TimeBasedKeyValueStore {

    private Map<String, List<Pair>> map = new HashMap<>();

    private static class Pair {
        private String value;
        private int timestamp;

        public Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    public _981_TimeBasedKeyValueStore() {

    }

    public void set(String key, String value, int timestamp) {
        Pair p = new Pair(value, timestamp);
        map.computeIfAbsent(key, k -> new ArrayList()).add(p);
    }

    public String get(String key, int timestamp) {
        List<Pair> pairs = map.get(key);
        if (pairs == null || pairs.size() == 0) {
            return "";
        }

        int start = 0;
        int end = pairs.size() - 1;

        int index = -1;
        while (start <= end) {
            int m = start + (end - start) / 2;
            Pair mv = pairs.get(m);
            if (mv.timestamp == timestamp) {
                return mv.value;
            } else if (mv.timestamp < timestamp) {
                start = m + 1;
            } else {
                end = m - 1;
            }
        }
        if (end < 0) {
            return "";
        }
        Pair p = pairs.get(end);
        return p.value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */