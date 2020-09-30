package ListNode;

import ListNode.ListNode;
import org.junit.Test;

public class LinkedListCycleII {


    //我们知道，当存在环的时候，fast和slow必然会在环中某一处相遇，假设相遇点距离start为m，于是slow和fast在m处相遇时，slow走了：x+ky+m，fast走了：x+ty+m。因为fast走的为slow的两倍，于是：
    // 2 * (x + ky + m) = x + ky + m
    // --> ty = x + m + 2ky
    // ty可以被y整除，所以x+m+2ky应当也能被y整除，即(x+m) mod y=0。于是，可以推断，当二者在m出相遇时，再绕环走x步，便一定可以到达环的起点。

    /**
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;



        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                System.out.println("_-------" + slow.val);

                slow = head;


                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        if (head == null) return null;


        ListNode slower = head;
        ListNode faster = head;

        while(faster.next != null && faster.next.next != null) {

            slower = slower.next;
            faster = faster.next.next;

            if (slower == faster) {

                slower = head;

                while(slower != faster) {
                    slower = slower.next;
                    faster = faster.next;
                }

                return slower;
            }
        }

        return null;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);


        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);

        head.next = node4;
        node4.next = node3;
        node3.next = node2;
        node2.next = node4;

        System.out.println(detectCycle(head).val);
        System.out.println(detectCycle2(head).val);

    }
}
