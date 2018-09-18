package ReverseLinkedList;


public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        System.out.println(reverse(a1));

    }


    public static ListNode reverse(ListNode head) {

        if (head == null) return head;

        if (head.next == null) return head;


        ListNode  prev =  head;

        ListNode cur = prev.next;

        prev.next = null;


        while (cur != null) {

            ListNode temp = cur;

            cur = cur.next;


            temp.next = prev;

            prev = temp;

        }


        return prev;
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
