package recursion;

import org.junit.Test;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode newNode = new ListNode(-1);

        if (l1.val > l2.val) {
            newNode.val = l2.val;
            newNode.next = mergeTwoLists(l1, l2.next);
        } else {
            newNode.val = l1.val;
            newNode.next = mergeTwoLists(l1.next, l2);
        }
        return newNode;
    }

    @Test
    public void test() {
        ListNode h1 = new ListNode(0);
        h1.next = new ListNode(4);
        h1.next.next = new ListNode(6);

        ListNode h2 =  new ListNode(3);
        h2.next = new ListNode(4);
        h2.next.next = new ListNode(5);

        System.out.println(mergeTwoLists(h1, h2));
    }
}
