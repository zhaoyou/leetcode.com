package AddTwoNumbers;

import org.junit.Test;

/**
 * Created by zhaoyou on 20/02/2017.
 */
public class AddTwoNumbers {

    public static  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return calc(l1, l2, 0);
    }

    private ListNode calc(ListNode l1, ListNode l2, int padding) {


        if (l1 == null && l2 == null) {
            if (padding != 0) {
                return new ListNode(1);
            }
            return null;
        } else {
            int result = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val  : 0) + padding;
            int nextResult = result / 10;
            ListNode currentNode = new ListNode(result % 10);
            currentNode.next = calc(l1 != null ? l1.next : l1, l2 != null ? l2.next : l2, nextResult);
            return currentNode;
        }
    }

    @Test
    public void test3() {
        ListNode first1 = new ListNode(2);
        ListNode first2 = new ListNode(4);
        first1.next = first2;
        ListNode first3 = new ListNode(3);
        first2.next = first3;


        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(6);
        node1.next = node2;
        ListNode node3 = new ListNode(4);
        node2.next = node3;
        System.out.printf("return: " + new AddTwoNumbers().addTwoNumbers(first1, node1));

    }

    @Test
    public void test2() {

        ListNode first1 = new ListNode(1);
        ListNode first2 = new ListNode(8);
        first1.next = first2;


        ListNode node1 = new ListNode(0);
        System.out.printf("return: " + new AddTwoNumbers().addTwoNumbers(first1, node1));


    }

    @Test
    public void test1() {
        ListNode first1 = new ListNode(5);
        ListNode node1 = new ListNode(5);


        System.out.printf("return: " + new AddTwoNumbers().addTwoNumbers(first1, node1));
    }

    @Test
    public void test4() {
        ListNode first1 = new ListNode(0);
        ListNode node1 = new ListNode(0);


        System.out.printf("return: " + new AddTwoNumbers().addTwoNumbers(first1, node1));
    }
}

