package ListNode;

import ListNode.ListNode;
import org.junit.Test;

public class RemoveLinkedListElements {


    @Test
    public void test() {
        ListNode head = new  ListNode(1);
        head.next = new  ListNode(1);
        head.next.next = new  ListNode(6);
        head.next.next.next = new  ListNode(1);
        head.next.next.next.next = new  ListNode(4);
        head.next.next.next.next.next = new  ListNode(5);
        head.next.next.next.next.next.next = new  ListNode(6);
        head.next.next.next.next.next.next.next = new  ListNode(1);


        System.out.println(removeElements(head, 1));

    }


    public ListNode removeElements(ListNode head, int val) {

        if (head == null) return null;

        ListNode dummy = new ListNode(0);

        dummy.next = head;

        ListNode prev = dummy;

        ListNode cur = head;

        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
            } else {
                prev = prev.next;
            }

            cur = cur.next;
        }

        return dummy.next;
    }

    public ListNode removeElements2(ListNode node, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = node;

        node = dummy;

        while(node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }

        return dummy.next;
    }
}
