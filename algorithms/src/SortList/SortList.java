package SortList;

import ListNode.ListNode;
import org.junit.Test;


/**
 * reference: https://siddontang.gitbooks.io/leetcode-solution/content/linked_list/sort_list.html
 */

public class SortList {


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

        System.out.println(sortList(head));
    }


    public ListNode sortList(ListNode head) {
        return sort(head);
    }


    private ListNode sort(ListNode head) {


        if (head == null || head.next == null) return head;


        ListNode slow = head;
        ListNode fast = head;

        // 得到中间指针
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        // 需要把慢指针的后部分分开 fast指向后部分。同时设置slow.next 为null
        fast = slow.next;
        slow.next = null;


        ListNode first = sort(head);
        ListNode second = sort(fast);

        return merge(first, second);
    }


    private ListNode merge(ListNode first, ListNode second) {

        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;

        while(first != null && second != null) {

            if (first.val > second.val) {
                prev.next = second;
                second = second.next;
            } else {
                prev.next = first;
                first = first.next;
            }

            prev = prev.next;
        }

        if (first != null) {
            prev.next = first;
        }

        if (second != null) {
            prev.next = second;
        }

        return dummy.next;
    }
}
