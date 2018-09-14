package MergeTwoSortedLists;

public class MergeTwoSortedLists {

    public static void main(String[] args) {

        /**
         Input: 1->2->4, 1->3->4
         Output: 1->1->2->3->4->4
         */

        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(5);
        ListNode a4 = new ListNode(6);

        a1.next = a2;
        a2.next = a4;

        ListNode b1 = new ListNode(2);
        ListNode b3 = new ListNode(4);
        ListNode b4 = new ListNode(6);

        b1.next = b3;
        b3.next = b4;

        ListNode result = mergeTwoLists(a1, b1);
        System.out.println("result: " + result);

        System.out.println("hello world");
    }

    /**
     *
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

      ListNode first = new ListNode(0);
      ListNode head = first;

      while(l1 != null || l2 != null) {

        if (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                first.next = l2;
                l2 = l2.next;
            } else {
                first.next = l1;
                l1 = l1.next;
            }

            first = first.next;
        }

        if (l1 == null && l2 != null) {
            while(l2 != null) {
                first.next = l2;
                first = first.next;
                l2 = l2.next;
            }

        }

        if (l2 == null && l1 != null) {

            while(l1 != null) {
                first.next = l1;
                first = first.next;
                l1 = l1.next;
            }
        }

      }

      return head.next;
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
