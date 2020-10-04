package ListNode;

import org.junit.Test;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        int i = 0;

        while(first != null) {
            first = first.next;
            i++;

            if (i == n) {
                break;
            }
        }


        while(first.next != null) {
            first = first.next;
            second = second.next;
        }


        ListNode next = second.next.next;
        second.next = next;

        return dummy.next;

    }

    @Test
    public void test() {
        ListNode head1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
//
        head1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;

        System.out.println(removeNthFromEnd(head1, 2));

    }
}
