package ListNode;


import ListNode.ListNode;
import org.junit.Test;

public class OddEvenLinkedList {

    @Test
    public void test() {

        ListNode head = new  ListNode(1);
        head.next = new  ListNode(2);
        head.next.next = new  ListNode(3);
        head.next.next.next = new  ListNode(4);
        head.next.next.next.next = new  ListNode(5);
        head.next.next.next.next.next = new  ListNode(6);
        head.next.next.next.next.next.next = new  ListNode(7);
       // head.next.next.next.next.next.next.next = new  ListNode(8);


        System.out.println(oddEvenList2(head));
    }

    public ListNode oddEvenList2(ListNode head) {

        if (head == null || head.next == null) return null;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while(even != null && even.next != null) {

            odd.next = even.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }

    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) return head;

        ListNode dummy = new ListNode(0);
        ListNode even = dummy;

        ListNode odd = head;

        while (odd != null) {


            even.next = odd.next;
            even = even.next;


            if (odd.next == null || odd.next.next == null) {
                break;
            } else {
                ListNode next  = odd.next.next;
                odd.next = odd.next.next;
                odd = next;
            }
        }

        odd.next = dummy.next;

        return head;
    }
}
