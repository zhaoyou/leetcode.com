package interviewEasy.LinkedList;

import ListNode.ListNode;
import org.junit.Test;

public class MergeTwoSortedLists {


    @Test
    public void test() {
        ListNode h1 = new  ListNode(0);
        h1.next = new  ListNode(1);
        h1.next.next = new  ListNode(3);
        h1.next.next.next = new  ListNode(5);
        h1.next.next.next.next = new  ListNode(7);

        ListNode h2 = new  ListNode(1);
        h2.next = new  ListNode(1);
        h2.next.next = new  ListNode(4);
        h2.next.next.next = new  ListNode(6);
        h2.next.next.next.next = new  ListNode(9);

        System.out.println(mergeTwoLists(h1, h2));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);

        ListNode p = dummy;

        while(l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                p.next = new ListNode(l2.val);
                l2 = l2.next;

            } else {
                p.next = new ListNode(l1.val);
                l1 = l1.next;
            }

            p = p.next;
        }

        while(l1 != null) {
            p.next = new ListNode(l1.val);
            l1 = l1.next;
            p = p.next;
        }

        while (l2 != null) {
            p.next = new ListNode(l2.val);
            l2 = l2.next;
            p = p.next;
        }

        return dummy.next;

    }
}
