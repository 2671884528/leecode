package lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @auther 郭永钢
 * @data 2020/12/31 9:33
 * @desc: 模拟缓存策略，删除最近未使用的
 */

public class LRUCache extends LinkedHashMap<Integer, String> {

    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
        return super.size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, "1");
        cache.put(2, "2");
        cache.put(3, "3");
        System.out.println(cache.keySet());
        cache.put(4, "4");
        System.out.println(cache.keySet());
        cache.put(3, "3");
        System.out.println(cache.keySet());
    }


}
