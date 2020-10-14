package ListNode;

import java.util.Stack;

/**
 * reference:
 * https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/discuss/150321/Easy-Understanding-Java-beat-95.7-with-Explanation
 */
public class FlattenAMultilevelDoublyLinkedList {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };


    public Node flatten(Node head) {
        Node p = head;

        while(head != null) {

            if (head.child == null) {
                head = head.next;
                continue;
            }

            Node temp = head.child;

            while(temp.next != null) {
                temp = temp.next;
            }


            temp.next = head.next;

            if (head.next != null) head.next.prev = temp;


            head.next = head.child;
            head.child.prev = head;
            head.child = null;


        }

        return p;
    }

//    public Node flatten2(Node head) {
//        Node p = head;
//
//        Stack<Node> stack = new Stack<>();
//
//        while(head != null || !stack.isEmpty()) {
//
//            while (head != null && head.child != null) {
//
//                head.next = head.child;
//                head.child.prev = head;
//
//                stack.push(head.next);
//
//                head = head.child;
//
//            }
//
//            if (head != null ) head = head.next;
//            else head = stack.pop();
//
//        }
//
//        return p;
//    }


}
