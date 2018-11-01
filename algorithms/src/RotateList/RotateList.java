package RotateList;



public class RotateList {


    public static void main(String[] args) {
        RotateList.ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);


        ListNode r = rotateList(head, 9);

        System.out.println(r);

    }

    static ListNode rotateList(ListNode head, int k) {

        if (k < 1) return head;

        if (head == null) return head;

        int len = 1;

        RotateList.ListNode cur = head;

        while(cur.next != null) {
            cur = cur.next;
            len ++;
        }

        cur.next = head;

        int pre = len - k % len - 1;

        ListNode preNode = head;


        while(pre > 0) {
            preNode = preNode.next;
            pre --;
        }

        head = preNode.next;
        preNode.next = null;

        return head;

    }


    static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "NodeList{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
