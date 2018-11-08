package ListNode;


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

        System.out.println(reverseByRecursive(a1));

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

    public static ListNode reverse2(ListNode head) {

        ListNode prev = null;
        ListNode next = null;
        ListNode cur = head;

        while(cur != null) {
            next = cur.next;
            cur.next = prev;

            prev = cur;
            cur = next;
        }


        head = prev;

        return head;
    }


    public static ListNode reverse3(ListNode head) {

        ListNode prev = null;
        ListNode cur = head;

        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;

            prev = cur;
            cur = next;
        }

        head = prev;

        return head;
    }


    // 迭代
    public static ListNode reverse4(ListNode head) {

        ListNode prev = head;

        if (head.next == null) return head;

        ListNode r = reverse4(head.next);

        System.out.println("r: " + r.toString() + " head: " + head.val);

        r.next = head;
        head.next = null;



        //r = head;

        return prev;

    }

    // 递归

    public static ListNode reverseByRecursive(ListNode head) {
      if (head == null || head.next == null) return head;

      return reverseHelper(head, null);
    }

    private static ListNode reverseHelper(ListNode cur, ListNode prev) {
        if (cur.next == null) {
            cur.next = prev;
            return cur;
        }

        ListNode next = cur.next;
        cur.next = prev;
        return reverseHelper(next, cur);
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
