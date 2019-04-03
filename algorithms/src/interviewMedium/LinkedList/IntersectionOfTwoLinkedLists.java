package interviewMedium.LinkedList;

import ListNode.ListNode;
import org.junit.Test;

public class IntersectionOfTwoLinkedLists {

    @Test
    public void test() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(4);


        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next  = new ListNode(7);

       // l1.next.next.next = l2.next;

        System.out.println(getIntersectionNode(l1, l2));


    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode pa = headA;
        ListNode pb = headB;

        while(pa != null && pb != null) {

            if (pa == pb) return pa;

            if (pa.next == null && pb.next == null) return null;

            pa = pa.next != null ? pa.next : headB;
            pb = pb.next != null ? pb.next : headA;

           // System.out.println("pa: " + pa.val);


        }
        return null;
    }
}
