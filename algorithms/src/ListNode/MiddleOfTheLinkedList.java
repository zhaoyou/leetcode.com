package ListNode;

import org.junit.Test;

public class MiddleOfTheLinkedList {

    @Test
    public void test() {

        ListNode h1 = new  ListNode(0);
        h1.next = new  ListNode(1);
        h1.next.next = new  ListNode(2);
        h1.next.next.next = new  ListNode(3);

        System.out.println(middleNode(h1));
    }

    public ListNode middleNode(ListNode head) {

        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null) fast = fast.next;
        }
        return slow;
    }
}
