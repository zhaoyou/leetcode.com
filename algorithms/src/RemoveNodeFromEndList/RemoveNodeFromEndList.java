package RemoveNodeFromEndList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class RemoveNodeFromEndList {

    public static void main(String[] args) {
        ListNode firstNode = new ListNode(1);
        ListNode secondNode = new ListNode(2);
        ListNode thirdNode = new ListNode(3);
        ListNode fourthNode = new ListNode(4);
        ListNode fifthNode = new ListNode(5);

        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = fifthNode;

        //System.out.println(firstNode.toString());

        //removeNthFromEnd(firstNode, 5, 0);


        ListNode r = removeNthFromEnd(firstNode, 4);

        System.out.println("firstNode: " + firstNode.toString());

        System.out.println("r: " + r.toString());


    }


    public static  ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        ListNode fastNode = head;
        ListNode slowNode = head;

        for (int i = 0; i < n; i++) {
            fastNode = fastNode.next;
        }

        if (fastNode == null) {
            head = head.next;
            return head;
        }

        while(fastNode.next != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }

        slowNode.next = slowNode.next.next;

        return head;
    }

    // public static int removeNthFromEnd(ListNode head, int n, int index) {


    //     if (head == null) {
    //         System.out.println("all index: " + index);
    //         return index;
    //     } 

    //     System.out.println(head.val);

    //     index = index + 1;

    //     int size = removeNthFromEnd(head.next, n, index);


        
    //     if (size - n  == index) {
    //             head.next = head.next.next;
    //     }

    //     if (size == n && index == 1) {

    //         System.out.println("head: " + head  + " \nhead.next: " + head.next);
    //         head = head.next;
    //     }
    
    //     System.out.println("size: " + size + " index: " + index + " n: " + n + " head: " + head);

    //     return size;
    // }

    // public static ListNode foreachNode(ListNode head, int n, int index) {
    //     if (head == null) {
    //         return null;
    //     }

    //     index = index + 1;

    //     int size = 0;

    //     ListNode a = foreachNode(head.next, n, index);
        
    //     if (a == null) {
    //         System.out.println("size: " + index);
    //         size = index;
    //     } 


    //     //System.out.println("a: " + a);

    //     //if (head == null)  size = index;


    //     System.out.println("=======: " + (size - n ));
        
    //     if (size - n  == index) {
    //         head.next = head.next.next;
    //         System.out.println("head" + head.val + " next: " + head.next.next);
    //     }

    //     // if (size == n && index == 1) {

    //     //     System.out.println("head: " + head  + " \nhead.next: " + head.next);
    //     //     head = head.next;
    //     // }

    //     System.out.println("size: " + size + " index: " + index + " n: " + n + " head: " + head);

    //     return head;
    // }
}

class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return "{val: " + val + " , next: " + next + "}";
        }
}