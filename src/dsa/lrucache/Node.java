package dsa.lrucache;
import java.util.*;

class Node {
    int key, value;
    Node prev, next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }


}

class LRUCache {

    private final int capacity;
    private Map<Integer, Node> map;

    private Node head, tail; // dummy nodes

    class Node {
        int key, value;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        head = new Node(0, 0); // dummy head
        tail = new Node(0, 0); // dummy tail

        head.next = tail;
        tail.prev = head;
    }

    // --------------------------
    // GET → O(1)
    // --------------------------
    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        remove(node);
        insert(node); // move to head

        return node.value;
    }

    // --------------------------
    // PUT → O(1)
    // --------------------------
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }

        if (map.size() == capacity) {
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }

        Node newNode = new Node(key, value);
        insert(newNode);
        map.put(key, newNode);
    }

    // --------------------------
    // DLL OPERATIONS
    // --------------------------
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }
}

class Main {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 10);
        cache.put(2, 20);

        System.out.println(cache.get(1)); // 10

        cache.put(3, 30); // evicts key 2

        System.out.println(cache.get(2)); // -1
    }
}

