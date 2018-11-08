package ListNode;


public class ReverseNodesInKGroup {
    public static void main(String[] args) {

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        ListNode a6 = new ListNode(6);


        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;


        int k = 3;

        System.out.println(new ReverseNodesInKGroup().reverseKGroup(a1, k));


    }

//    public static  ListNode reverseKGroup(ListNode head, int k) {
//
//        if (k < 2) return head;
//
//        ListNode dummy = new ListNode(-1);
//
//        dummy.next = head;
//
//        ListNode first = dummy;
//
//        ListNode cur = dummy.next;
//
//        int i = 0;
//
//        while(cur != null) {
//
//            i++;
//
//
//            if (i % k == 0) {
//                first = reverse(first.next, cur);
//
//                System.out.println("first: " + first);
//
//                //first = cur;
//                cur = cur.next;
//            } else {
//
//                cur = cur.next;
//            }
//
//        }
//
//        return dummy.next;
//    }
//
//    public static ListNode reverse(ListNode head, ListNode stopNode) {
//
//
//
//        if (head == null) return head;
//
//        if (head.next == null) return head;
//
//
//        ListNode prev =  head;
//
//        ListNode cur = prev.next;
//
//        //prev.next = null;
//
//
//        while (cur != stopNode) {
//
//            ListNode temp = cur;
//
//            cur = cur.next;
//
//
//            temp.next = prev;
//
//            prev = temp;
//
//        }
//
//        prev.next = stopNode;
//
//        return prev;
//    }


    /**
     * https://blog.csdn.net/linhuanmars/article/details/19957455
     * @param head
     * @param k
     * @return
     */

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null)
        {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int count = 0;
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur != null)
        {
            count ++;
            ListNode next = cur.next;
            if(count == k)
            {
                // k 之前的列表先reverse掉. 返回的pre为原始待翻转的列表。
                pre = reverse(pre, next);
                System.out.println("pre: " + pre);
                count = 0;
            }
            cur = next;
        }
        return dummy.next;
    }


    private ListNode reverse(ListNode pre, ListNode end)
    {
        if(pre==null || pre.next==null)
            return pre;
        ListNode head = pre.next;
        ListNode cur = pre.next.next;
        while(cur!=end)
        {
            ListNode next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        head.next = end;
        return head;
    }



    /**
     * ListNode
     */
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
