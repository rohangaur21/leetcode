package misc;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LFUCache {

    class Cache {
        int data;
        int frequency;

        public Cache(int data) {
            this.data = data;
            this.frequency = 1;
        }
    }

    private Map<Integer, Cache> lfu = null;
    private int capacity;

    public LFUCache(int capacity) {
        this.lfu = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
    }


    public int get(int key) {
        if (lfu.get(key) == null) return -1;
        lfu.get(key).frequency += 1;
        return lfu.get(key).data;
    }

    public void put(int key, int value) {

        if (isFull(lfu)) {
            int leastfrequency = Integer.MAX_VALUE;
            int leastKey = -1;
            for (Integer i : lfu.keySet()) {
                if (lfu.get(i).frequency < leastfrequency) {
                    leastfrequency = lfu.get(i).frequency;
                    leastKey = i;
                }
            }
            lfu.remove(leastKey);
            lfu.put(key, new Cache(value));
        } else {
            lfu.put(key, new Cache(value));
        }

    }

    private boolean isFull(Map<Integer, Cache> lfu) {
        return lfu.size() >= capacity;
    }


    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2 /* capacity */);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3.
        cache.put(4, 4);    // evicts key 1.
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}


