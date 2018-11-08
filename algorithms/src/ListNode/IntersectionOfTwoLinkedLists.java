package ListNode;

import ListNode.ListNode;
import org.junit.Test;


/**
 * reference: http://www.cnblogs.com/grandyang/p/4128461.html
 * reference: https://www.cnblogs.com/yuzhangcmu/p/4128794.html
 */
public class IntersectionOfTwoLinkedLists {



    @Test
    public void test() {
        ListNode a1 = new ListNode(11);
        ListNode a2 = new ListNode(12);

        ListNode b1 = new ListNode (21);
        ListNode b2 = new ListNode(22);
        ListNode b3 = new ListNode (23);

        ListNode c1 = new ListNode (31);
        ListNode c2 = new ListNode(32);
        ListNode c3 = new ListNode (33);


        a1.next = a2;
        a2.next = c1;
        c1.next = c2;
        c2.next = c3;

        b1.next = b2;
        b2.next = b3;
        b3.next = c1;

        System.out.println(getIntersectionNode2(a1, b1));

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;

        ListNode first = headA;
        ListNode second = headB;

        while(first != second) {

            if (first.next == null) {
                first = headB;
            } else {
                first = first.next;
            }

            //first = first.next == null ? headB : first.next;

            if (second.next == null) {
                second = headA;
            } else {
                second = second.next;
            }

            //second = second.next == null ? headA : second.next;

        }

        return first;


    }


    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;

        int lena = getCount(headA);
        int lenb = getCount(headB);

        while(lena != lenb) {
            if (lena > lenb) {
                headA = headA.next;
                lena--;
            }

            if (lenb > lena) {
                headB = headB.next;
                lenb--;
            }
        }

        while(headA != null) {

            if (headA != headB) {
                headA = headA.next;
                headB = headB.next;
            } else {
                return headA;
            }
        }

        return null;
    }


    private int getCount(ListNode head) {
        int i = 0;
        ListNode cur = head;
        while(cur != null) {
            cur = cur.next;
            i ++;
        }
        return i;
    }

}
