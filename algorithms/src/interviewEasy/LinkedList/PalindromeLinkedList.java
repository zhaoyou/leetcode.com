package interviewEasy.LinkedList;

import ListNode.ListNode;
import org.junit.Test;

public class PalindromeLinkedList {

    @Test
    public void test() {
        ListNode h1 = new  ListNode(0);
        h1.next = new  ListNode(0);
//        h1.next.next = new  ListNode(1);
//        h1.next.next.next = new  ListNode(1);
        //h1.next.next.next.next = new  ListNode(5);

        System.out.println(isPalindrome(h1));
    }


    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;


        while(fast != null) {
            slow = slow.next;
            fast = fast.next;

            if (fast != null) fast = fast.next;
        }


        ListNode newNode = reverse(slow);

        fast = head;

        while(fast != null && newNode != null) {
            if (fast.val != newNode.val) return false;
            fast = fast.next;
            newNode = newNode.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {

        ListNode prev = null;

        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
