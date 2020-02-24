package recursion;

import org.junit.Test;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode next = head.next.next;
        ListNode newHead = head.next;

        head.next.next = head;
        head.next = swapPairs(next);;

        return newHead;

    }

    @Test
    public void test() {
        ListNode h1 = new ListNode(0);
        h1.next = new ListNode(1);
        h1.next.next = new ListNode(2);
        h1.next.next.next = new ListNode(3);
        h1.next.next.next.next = new ListNode(4);
        h1.next.next.next.next.next = new ListNode(5);


        System.out.println(h1.toString());

        System.out.println(swapPairs(h1).toString());
    }
}
