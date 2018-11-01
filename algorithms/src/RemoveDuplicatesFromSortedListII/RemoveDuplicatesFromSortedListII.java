package RemoveDuplicatesFromSortedListII;


public class RemoveDuplicatesFromSortedListII {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        ListNode second = new ListNode(1);
        second.next = new ListNode(1);
        second.next.next = new ListNode(1);
        second.next.next.next = new ListNode(2);
        second.next.next.next.next = new ListNode(3);

        System.out.println(deleteDuplicates(head));

        System.out.println(deleteDuplicates(second));

    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode start = new ListNode(-1);
        start.next = head;
        ListNode prev = start;

        while(prev.next != null) {


            ListNode cur = prev.next;

            while(cur.next != null && cur.val == cur.next.val) cur = cur.next;

            if (cur == prev.next) {
                prev = prev.next;
            } else {
                prev.next = cur.next;
            }



        }
        return start.next;
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
