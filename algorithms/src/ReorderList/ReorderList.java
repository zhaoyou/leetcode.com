package ReorderList;

import ListNode.ListNode;
import org.junit.Test;

/**
 * reference: http://bangbingsyb.blogspot.com/2014/11/leetcode-reorder-list.html
 */
public class ReorderList {

    @Test
    public void test() {
        ListNode head = new  ListNode(1);
        head.next = new  ListNode(2);
        head.next.next = new  ListNode(3);
        head.next.next.next = new  ListNode(4);
        head.next.next.next.next = new  ListNode(5);
        head.next.next.next.next.next = new  ListNode(6);

        reorderList(head);
    }

    /**
     * 寻找列表的中级节点
     * @param head
     * @return
     */
    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;

            if (fast.next != null) fast = fast.next;
        }

        return slow;
    }


    /**
     * 翻转一个列表
     * @param head
     * @return
     */
    private ListNode reverseList(ListNode head) {

        if (head == null) return null;

        ListNode prev = null;

        ListNode cur = head;

        while(cur != null) {

            ListNode next = cur.next;
            cur.next = prev;

            prev = cur;
            cur = next;
        }


        return prev;
    }


    public void reorderList(ListNode head) {

        ListNode mid = findMid(head);
        ListNode right = reverseList(mid);
        ListNode left = head;

        while(right != null && right.next != null) {


            ListNode target = right;

            right = right.next;

            target.next = left.next;

            left.next = target;

            left = left.next.next;
        }

        System.out.println(head);


    }
}
