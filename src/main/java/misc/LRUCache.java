package misc;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    private Map<Integer, Integer> lru = null;

    public LRUCache(int capacity) {
        lru = new LRUMap(capacity);
    }

    public int get(int key) {
        return lru.get(key) == null ? -1 : lru.get(key);
    }

    public void put(int key, int value) {
        lru.put(key, value);
    }

    static class LRUMap extends LinkedHashMap {
        private int capacity;

        public LRUMap(int capacity) {
            super(capacity, .75f, true);
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return this.size() > capacity;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* capacity */);
        System.out.println();
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}


