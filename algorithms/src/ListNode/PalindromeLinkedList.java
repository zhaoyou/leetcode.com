package ListNode;

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
       // System.out.println("result: " + isPalindrome(head));
        System.out.println("result: " + isPalindrome2(head));

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


    public boolean isPalindrome2(ListNode head) {

        if (head == null || head.next == null) return true;

        ListNode fast = head;
        ListNode slow = head;

        // 找到中间节点
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;

            if (fast != null) fast = fast.next;  // 很关键，能处理掉 对称的节点
        }

        ListNode prev = null;

        // 反转后部分
        while(slow != null) {
            ListNode next = slow.next;
            slow.next = prev;

            prev = slow;
            slow = next;

        }

        // 比较开始部分和反转后的节点
        while(prev != null && head != null) {
            if (prev.val != head.val) return false;
            prev = prev.next;
            head = head.next;
        }

        return true;
    }

}