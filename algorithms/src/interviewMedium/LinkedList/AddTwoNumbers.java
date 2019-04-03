package interviewMedium.LinkedList;

import ListNode.ListNode;
import org.junit.Test;

public class AddTwoNumbers {

    @Test
    public void test() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next  = new ListNode(7);

        System.out.println(addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        int sign = 0;

        while(l1 != null || l2 != null) {

            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;

            int sum = sign + v1 + v2 ;

            sign = sum / 10;
            sum = sum % 10;


            p.next = new ListNode(sum);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (sign == 1) {
            p.next = new ListNode(1);
        }


        return dummy.next;
    }
}
