package SimpleDataStruct;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    LinkedHashMap<Integer, Integer> linkedHashMap;
    int capacity;
    public LRUCache(int capacity) {
        this.linkedHashMap = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        int value = -1;
        if (linkedHashMap.containsKey(key)) {
            value = linkedHashMap.get(key);
            linkedHashMap.remove(key);
            linkedHashMap.put(key,value);
        }
        return value;
    }

    public void put(int key, int value) {
        if (linkedHashMap.containsKey(key)) {
            linkedHashMap.remove(key);
        }
        else if (linkedHashMap.size() == capacity) {
            for (Map.Entry<Integer, Integer> entry: linkedHashMap.entrySet()) {
                linkedHashMap.remove(entry.getKey());
                break;
            }
        }
        linkedHashMap.put(key, value);
    }
}
