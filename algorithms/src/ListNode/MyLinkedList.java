package ListNode;

import org.junit.Test;

public class MyLinkedList {

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node() {}

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }



    Node head;

    int len = 0;

    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= len) return -1;
        int i = 0;
        Node p = head;
        while(p != null) {
            if (index == i) return p.val;
            p = p.next;
            i++;
        }
        return -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node summy = new Node(val);
        summy.next = head;
        head = summy;
        len++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {

        if (head == null) {
            head = new Node(val);
        } else {
            Node p = head;

            while(p.next != null) {
                p = p.next;
            }

            p.next = new Node(val);
        }


        len++;
    }

    /** Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > len) return;

        Node add = new Node(val);
        Node dummy = new Node(-1);

        dummy.next = head;



        Node p = dummy;

        int i = 0;

        while(p != null) {

            if (i == index) {
                Node next = p.next;
                p.next = add;
                add.next = next;
                break;
            }
            p = p.next;
            i++;
        }

        head = dummy.next;

        len++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {

        if (index >= len) return;

        Node dummy = new Node(-1);

        dummy.next = head;
        Node p = dummy;

        int i = 0;

        while(p.next != null) {

            if (i == index) {
                Node next = p.next.next;
                p.next = next;
                break;
            }

            p = p.next;
            i++;
        }

        head = dummy.next;

        len--;

    }

    @Test
    public void test() {
      MyLinkedList obj = new MyLinkedList();
      obj.addAtHead(1);
      obj.addAtTail(3);
      obj.addAtIndex(1,2);
        System.out.println(obj.head);
        System.out.println("get(1): " + obj.get(1));
      obj.deleteAtIndex(1);
        System.out.println(obj.head);
      int i = obj.get(1);
        System.out.println("get(1): " + i);
    }

}
