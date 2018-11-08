package ListNode;


import ListNode.ListNode;
import org.junit.Test;

public class ReverseLinkedListII {
    
    @Test
    public void test() {
        ListNode head = new  ListNode(1);
        head.next = new  ListNode(2);
        head.next.next = new  ListNode(3);
        head.next.next.next = new  ListNode(4);
        head.next.next.next.next = new  ListNode(5);
        head.next.next.next.next.next = new  ListNode(6);

        System.out.println(reverseBetween(head, 1, 5));
    }
    

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode prev = new ListNode(0) ;
        prev.next = head;
        ListNode cur = head;

        ListNode a = null;
        ListNode b = null;
        ListNode before = prev;

        if (m == n) return head;

        int i = 1;

        while(cur != null) {

            ListNode next = cur.next;

            if (i == m) {   // 标记第一个位置，和 第一个位置的前一个位置
                a = prev;
                b = cur;
               // cur.next = prev;

            } else if (i > m && i < n) { // 翻转m，n区间内的元素
                cur.next = prev;
            } else if (i == n) { // 结束翻转后，把之前标记的元素衔接上
                cur.next = prev;

                a.next = cur;
                b.next = next;

            }

            prev = cur;
            cur = next;
            i++;
        }


        return before.next;
    }

    public ListNode reverse(ListNode head, ListNode last) {
        ListNode prev = null;
        ListNode cur = head;

        while(cur != null) {

            ListNode next = cur.next;
            cur.next = prev;

            prev = cur;

            if (cur == last) {
                break;
            }

            cur = next;


        }
        return prev;
    }

}
