package recursion;

import org.junit.Test;

public class ReverseLinkedList {

    /**
     * https://www.autodraw.com/share/YP7PLHC6QJDN
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head.next == null) return head;

        ListNode newNode = reverseList(head.next);

        head.next.next= head;
        head.next = null;

        return newNode;

    }

    public ListNode reverseList2(ListNode head) {

        ListNode prev = null;
        while(head != null ) {
            ListNode next = head.next;
            head.next = prev;

            prev = head;
            head = next;
        }


        return prev;
    }


    @Test
    public void test() {
        ListNode h1 = new ListNode(0);
        h1.next = new ListNode(1);
        h1.next.next = new ListNode(2);
        h1.next.next.next = new ListNode(3);
        h1.next.next.next.next = new ListNode(4);
        h1.next.next.next.next.next = new ListNode(5);


        System.out.println(reverseList2(h1));

    }
}
