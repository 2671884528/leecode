package lru;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @auther 郭永钢
 * @data 2020/12/31 9:33
 * @desc: 模拟缓存策略，删除最近未使用的
 */

public class LRUCache2 {

    private class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;


        public Node() {
            this.prev = this.next = null;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }
    }

    private class DLinkList<K,V> {
        Node<K, V> head;
        Node<K, V> tail;

        public DLinkList() {
            head = new Node<>();
            tail = new Node<>();

            head.next = tail;
            tail.prev = head;
        }

        public void addHead(Node<K,V> node){
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        public void removeNode(Node<K, V> node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }

        public Node<K,V> getLast(){
            return tail.prev;
        }
    }

    private int capacity;

    Map<Integer,Node<Integer,Integer>> map;

    DLinkList<Integer,Integer> list;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        list = new DLinkList<>();
    }

    public int get(int key){
        if (!map.containsKey(key)){
            return -1;
        }

        Node<Integer, Integer> node = map.get(key);
        list.removeNode(node);
        list.addHead(node);

        return node.value;
    }

    public void put(int key,int value){
        if (map.containsKey(key)){
            Node<Integer, Integer> node = map.get(key);
            node.value = value;
            map.put(key, node);
            list.removeNode(node);
            list.addHead(node);
        }else {
            if (map.size() == capacity){
                Node<Integer, Integer> node = list.getLast();
                map.remove(node.key);
                list.removeNode(node);
            }
            Node<Integer, Integer> newNode = new Node<>(key,value);
            map.put(key,newNode);
            list.addHead(newNode);
        }
    }

    public static void main(String[] args) {
        LRUCache2 cache = new LRUCache2(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        System.out.println(cache.map.keySet());
        System.out.println(cache.list.getLast().key);
        cache.put(4, 4);
        System.out.println(cache.map.keySet());
        System.out.println(cache.list.getLast().key);

        cache.put(3, 3);
        System.out.println(cache.map.keySet());
        System.out.println(cache.list.getLast().key);

    }
}
