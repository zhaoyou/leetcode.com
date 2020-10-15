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

    public Node flatten2(Node head) {
        Node cur = head;

        Stack<Node> stack = new Stack<>();

        while(cur != null)  {

           if (cur.child != null) {

               stack.push(cur.next); // cur.next 可能为null

               cur.next = cur.child;

               cur.child.prev = cur;

               cur.child = null;


           } else if (cur.next == null && !stack.isEmpty()) {


               cur.next = stack.pop();

               if (cur.next != null) cur.next.prev = cur;


           }

            cur = cur.next;

        }

        return head;
    }


}
