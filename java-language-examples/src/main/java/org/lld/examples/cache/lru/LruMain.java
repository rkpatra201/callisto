package org.lld.examples.cache.lru;

import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LruMain {
    public static void main(String[] args) {
      Cache<String, String> cache = new Cache<>(3, CacheEvictionType.LRU);
      cache.put("k1","v1");
      cache.put("k2","v1");
      cache.put("k3","v1");
      cache.put("k4","v1");
    }

    private static enum CacheEvictionType {
        LRU, MRU
    }

    private static class Cache<K, V> {
        private Map<K, Node<K, V>> cacheMap;
        private LinkedList<Node<K, V>> linkedList;

        private int maxSize;
        private CacheEvictionType cacheEvictionType;

        public Cache(int maxSize, CacheEvictionType cacheEvictionType) {
            this.maxSize = maxSize;
            this.cacheMap = new ConcurrentHashMap<>();
            this.linkedList = new LinkedList<>();
            this.cacheEvictionType = cacheEvictionType;
        }

        public void put(K key, V value) {

            if (cacheMap.containsKey(key)) {
                Node<K, V> oldNode = cacheMap.get(key);
                linkedList.remove(oldNode);
                Node<K, V> newNode = new Node<>(key, value);
                linkedList.addFirst(newNode);
                cacheMap.put(key, newNode);
            }

            if (!cacheMap.containsKey(key)) {
                Node<K, V> newNode = new Node<>(key, value);
                linkedList.addFirst(newNode);
                cacheMap.put(key, newNode);
            }

            if (cacheMap.size() > maxSize) {
                Node<K, V> node = cacheEvictionType == CacheEvictionType.LRU ? linkedList.removeLast() : linkedList.removeFirst();
                cacheMap.remove(node.key);
            }

        }

        public V get(K key) {
            if (!cacheMap.containsKey(key)) {
                return null;
            }
            Node<K, V> node = cacheMap.get(key);
            linkedList.remove(node);
            linkedList.addFirst(node);
            return node.value;
        }

        public void remove(K key) {
            if (!cacheMap.containsKey(key)) {
                return;
            }
            Node<K, V> node = cacheMap.get(key);
            linkedList.remove(node);
            cacheMap.remove(node);
        }
    }

    private static class Node<K, V> {

        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
