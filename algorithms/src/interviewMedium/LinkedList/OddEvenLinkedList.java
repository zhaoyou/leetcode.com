package interviewMedium.LinkedList;

import ListNode.ListNode;
import org.junit.Test;

import java.util.List;

public class OddEvenLinkedList {

    @Test
    public void test() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(5);
        l1.next.next.next.next = new ListNode(6);
        System.out.println(oddEvenList(l1));
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode prev = even;


        while(odd.next != null && even.next != null) {
            odd.next =  odd.next.next ;
            even.next =  even.next.next;

            odd = odd.next;
            even = even.next;
        }

        odd.next = prev;

        return head;


    }
}
