package ListNode;

import org.junit.Test;

public class DoublyLinkedList {
    /** Initialize your data structure here. */

    class Node {
        public int val;
        public Node prev;
        public Node next;

        public Node() {}
        public Node(int val) {this.val = val;}

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }

    Node head;
    Node tail;
    int len = 0;

    public DoublyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    int get(int index) {
        if (index < 0 || index > len - 1) return -1;
        int k = 0;
        Node p = head;
        do {
            if (k == index) return p.val;
            p = p.next;
            k++;
        } while (p != null);

        return -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    void addAtHead(int val) {
        Node cur = new Node(val);

        if (len == 0) {
            head = cur;
            tail = cur;
        } else {
            cur.next = head;
            head.prev = cur;
            head = cur;
        }

        len++;
    }

    /** Append a node of value val to the last element of the linked list. */
    void addAtTail(int val) {
        Node cur = new Node(val);

        if (len == 0) {
            head = cur;
            tail = cur;
        } else {
            tail.next = cur;
            cur.prev = tail;

            tail = cur;
        }

        len++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    void addAtIndex(int index, int val) {
        if (index > len || index < 0) return;

        if(index == 0) {
            addAtHead(val);
            return;
        } else if (index == len) {
            addAtTail(val);
            return;
        }

        int k = 0;
        Node p = head;
        while (p != null) {
            if (k == index) {

                Node cur = new Node(val);

                cur.next = p;
                cur.prev = p.prev;


                p.prev.next = cur;
                p.prev = cur;


                len++;

                return;
            }
            p = p.next;
            k++;
        }

    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    void deleteAtIndex(int index) {
        if (index < 0 || index >= len) return;
        int k = 0;
        Node p = head;
        while (p != null) {
            if (k == index) {

                Node prev = p.prev;
                Node next = p.next;


                if (prev != null) {
                    prev.next = next;
                } else {
                    head = next;
                }

                if (next != null) {
                    next.prev = prev;
                } else {
                    tail = prev;
                }

                len--;

                return;
            }
            p = p.next;
            k++;
        }
    }

    @Test
    public void test() {
        DoublyLinkedList l = new DoublyLinkedList();
        l.addAtHead(1);
        l.addAtTail(2);
        System.out.println(l.get(0));
    }
}
