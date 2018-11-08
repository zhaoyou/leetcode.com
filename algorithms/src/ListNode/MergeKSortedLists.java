package ListNode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeKSortedLists {
    public static void main(String[] args) {
        /**
         * [
         *   1->4->5,
         *   1->3->4,
         *   2->6
         * ]
         * Output: 1->1->2->3->4->4->5->6
         */

        ListNode a1 = new ListNode(1);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);

        a1.next = a4;
        a4.next = a5;


        ListNode b1 = new ListNode(1);
        ListNode b3 = new ListNode(3);
        ListNode b4 = new ListNode(4);
        b1.next = b3;
        b3.next = b4;

        ListNode c2 = new ListNode(2);
        ListNode c6 = new ListNode(6);
        c2.next = c6;

        ListNode[] all = {a1, b1, c2};

        //ListNode result = mergeKLists(all);

        ListNode result2 = mergeKLists2(all);

        //System.out.println(result);

        System.out.println(result2);


    }

    /**
     * 先排序后，组装成一个ListNode
     * @param lists
     * @return
     */
    public static  ListNode mergeKLists(ListNode[] lists) {

        List<ListNode>  allListNode = new ArrayList<ListNode>();

        for (ListNode listNode: lists) {
            while(listNode != null) {
                allListNode.add(listNode);
                listNode = listNode.next;
            }
        }


        ListNode[] o = allListNode.toArray(new ListNode[allListNode.size()]);

        Arrays.sort(o, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val -  o2.val;
            }
        });

        ListNode first = new ListNode(0);
        ListNode result = first;

        for (ListNode node: o) {
            first.next = node;
            first = first.next;
        }

        return result.next;
    }



    public static ListNode mergeKLists2(ListNode[] lists) {

        if (lists.length == 0) return null;

        if (lists.length == 1) return lists[0];

        if (lists.length == 2) {
            return mergeTwoLists(lists[0], lists[1]);
        }

        return mergeTwoLists(
                mergeKLists2(Arrays.copyOfRange(lists, 0, lists.length/2)),
                mergeKLists2(Arrays.copyOfRange(lists, lists.length/2, lists.length))
        );
    }




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

}


