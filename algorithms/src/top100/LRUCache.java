package top100;

import java.util.HashMap;


/**
 * https://leetcode.com/problems/lru-cache/discuss/45911/Java-Hashtable-%2B-Double-linked-list-(with-a-touch-of-pseudo-nodes)
 */
public class LRUCache {

    DLinkedList head, tail;

    HashMap<Integer, DLinkedList> map = new HashMap<>();

    int capacity;



    
    public LRUCache(int capacity) {
        

        this.capacity = capacity;

        head = new DLinkedList();
        tail = new DLinkedList();

        head.next = tail;
        tail.prev = head;



    }
    
    public int get(int key) {
        
        DLinkedList node = map.get(key);

        if (node == null) {
            return -1;
        }


        removeNode(node);
        add(node);

        return node.value;
    }
    
    public void put(int key, int value) {

        DLinkedList node = map.get(key);

        if (node == null) {

            node = new DLinkedList();
            node.key = key;
            node.value = value;

            if (map.size() == capacity ) {
                DLinkedList n = catTail();
                this.map.remove(n.key);
            }

            add(node);

            this.map.put(key, node);


        } else {

            node.value = value;

            removeNode(node);
            add(node);
        }
        
    }

    private void add(DLinkedList node) {

        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;


    }

    private void removeNode(DLinkedList node) {

        DLinkedList next = node.next;
        DLinkedList prev = node.prev;

        next.prev = prev;
        prev.next = next;

    }

    private DLinkedList catTail() {

        DLinkedList node = tail.prev;
        removeNode(node);
        return node;
    }
}

class DLinkedList {

    DLinkedList prev,next;
    int key;
    int value;
}
