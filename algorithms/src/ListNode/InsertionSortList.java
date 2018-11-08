package ListNode;

import ListNode.ListNode;
import org.junit.Test;

/**
 * reference:
 * http://bangbingsyb.blogspot.com/2014/11/leetcode-insertion-sort-list.html
 * https://blog.csdn.net/linhuanmars/article/details/21144553
 */
public class InsertionSortList {


    @Test
    public void test() {
        ListNode head = new  ListNode(6);
        head.next = new  ListNode(5);
        head.next.next = new  ListNode(3);
        head.next.next.next = new  ListNode(1);
        head.next.next.next.next = new  ListNode(8);
        head.next.next.next.next.next = new  ListNode(7);
        head.next.next.next.next.next.next = new  ListNode(2);
        head.next.next.next.next.next.next.next = new  ListNode(4);

        System.out.println(insertionSortList(head));
    }


    public ListNode insertionSortList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode sumdy = new ListNode(0);

        while(head != null) {

            ListNode curNext = head.next;

            ListNode prev = sumdy;

            while(prev.next != null && prev.next.val <= head.val) {
                prev = prev.next;
            }

            head.next = prev.next;

            prev.next = head;

            head = curNext;
        }

        return sumdy.next;
    }

}
