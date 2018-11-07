package PalindromeLinkedList;

import ListNode.ListNode;
import org.junit.Test;


/**
 * reference: https://wjqwsp.github.io/2016/09/24/LeetCode-234-Palindrome-Linked-List-%E9%A2%98%E8%A7%A3/
 */
public class PalindromeLinkedList {

    @Test
    public void test() {
        ListNode head = new  ListNode(1);
        head.next = new  ListNode(2);
        head.next.next = new  ListNode(2);
        head.next.next.next = new  ListNode(2);
        head.next.next.next.next = new  ListNode(2);
        head.next.next.next.next.next = new  ListNode(1);
        System.out.println("result: " + isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) return true;

        ListNode prev  = null;
        ListNode first = head;


        // 找到LinkedList 中级点
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null  && fast.next.next != null) {

            fast = fast.next.next;
            slow = slow.next;
        }

        prev = slow.next;
        slow.next = null;

        // 翻转后部分
        ListNode p = null;
        while(prev != null) {

            ListNode next = prev.next;

            prev.next = p;

            p = prev;

            prev = next;
        }




        // 依次比较
        while (p != null && first != null) {
            if (p.val == first.val) {
                p = p.next;
                first = first.next;
            } else {
                break;
            }
        }

        return p == null ? true : false;
    }
}