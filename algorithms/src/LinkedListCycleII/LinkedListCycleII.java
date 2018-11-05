package LinkedListCycleII;

import ListNode.ListNode;

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
}
