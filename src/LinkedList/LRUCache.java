package LinkedList;

import java.util.*;

public class LRUCache {
    public static class Node {
        int key, value;
        Node pre, next;
        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private final int capacity;
    private final Node dummy = new Node(0, 0);
    private final Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy.pre = dummy;
        dummy.next = dummy;
    }

    public int get(int key) {
        Node node = getNode(key);
        return node == null ? -1 : node.value;
    }

    public void put(int key, int value) {
        Node node = getNode(key);
        if(node != null) {
            node.value = value;
            return;
        }
        Node node2 = new Node(key, value);
        map.put(key, node2);
        putNode(node2);
        if(map.size() > capacity) {
            Node tmp = dummy.pre;
            map.remove(tmp.key);
            removeNode(tmp);
        }
    }

    public Node getNode(int key) {
        Node node = map.get(key);
        if(node == null) return null;
        else {
            removeNode(node);
            putNode(node);
            return node;
        }
    }

    public void putNode(Node node) {
        Node tmp = dummy.next;
        dummy.next.pre = node;
        node.next = tmp;
        node.pre = dummy;
        dummy.next = node;
    }

    public void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
    }
}
