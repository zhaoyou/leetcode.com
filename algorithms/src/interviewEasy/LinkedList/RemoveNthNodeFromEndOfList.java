package interviewEasy.LinkedList;

import ListNode.ListNode;
import org.junit.Test;

import java.util.List;

public class RemoveNthNodeFromEndOfList {

    @Test
    public void test() {
        ListNode h1 = new  ListNode(0);
        h1.next = new  ListNode(1);
        h1.next.next = new  ListNode(2);
        h1.next.next.next = new  ListNode(3);
        h1.next.next.next.next = new  ListNode(4);

        System.out.println(removeNthFromEnd(h1, 2));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode fastNode = head;
        ListNode slowNode = head;

        int i = 0;


        while(fastNode != null) {
            i++;
            fastNode = fastNode.next;
            if (i == n) break;
        }


        if (fastNode == null) {
            head = head.next;
            return head;
        }

        while (fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }

        slowNode.next = slowNode.next.next;

        return head;
    }
}
