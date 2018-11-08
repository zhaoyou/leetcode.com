package ListNode;


import org.junit.Test;

public class PartitionList {

    @Test
    public void test() {
        ListNode head = new   ListNode(1);
        head.next = new   ListNode(4);
        head.next.next = new   ListNode(3);
        head.next.next.next = new   ListNode(2);
        head.next.next.next.next = new   ListNode(5);
        head.next.next.next.next.next = new   ListNode(2);

        System.out.println(partition(head, 3));

    }


    public ListNode partition(ListNode head, int x) {

        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);

        ListNode p1 = dummy1;
        ListNode p2 = dummy2;

        while(head != null) {

            if (head.val < x) {
                p1.next = head;
                p1 = p1.next;
            } else {
                p2.next = head;
                p2 = p2.next;
            }

            head = head.next;
        }

        p2.next = null;

        p1.next = dummy2.next;

        return dummy1.next;
    }

    static class ListNode {
        private int val;
        private ListNode next;
        public ListNode(int val) {this.val = val;}


        @java.lang.Override
        public java.lang.String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
