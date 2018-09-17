package SwapNodesinPairs;

public class SwapNodesinPairs {
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

        System.out.println(new SwapNodesinPairs().swapPairs(a1));

    }


    /**
     * https://skyyen999.gitbooks.io/-leetcode-with-javascript/content/questions/24md.html
     * @param head
     * @return
     */

    public ListNode swapPairs(ListNode head) {


        ListNode firstNode = new ListNode(0);

        firstNode.next = head;


        ListNode prev = firstNode;

        ListNode cur = head;

        ListNode nextNode;

        while(cur != null && cur.next != null) {


            nextNode = cur.next.next;

            cur.next.next = cur;


            prev.next = cur.next;


            cur.next = nextNode;

            //处理下一组

            prev = cur;

            cur = cur.next;

        }

        return firstNode.next;
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
