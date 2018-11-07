package ListNode;

import java.util.List;
import java.util.Stack;


/**
 * reference: 使用stack实现
 * https://blog.csdn.net/mine_song/article/details/70548158 (可优化）
 */

public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        ListNode cur1 = l1;
        ListNode cur2 = l2;

        while(cur1 != null) {
            stack1.push(cur1.val);
            cur1 = cur1.next;
        }

        while (cur2 != null) {
            stack2.push(cur2.val);
            cur2 = cur2.next;
        }

        int isAdd = 0;

        ListNode cur = null;

        while(!stack1.isEmpty() || !stack2.isEmpty()) {

            int sum = (stack1.isEmpty() ? 0 : stack1.pop())
                    + (stack2.isEmpty() ? 0 : stack2.pop());


            ListNode head = new ListNode((sum  + isAdd) % 10 );

            head.next = cur;

            cur = head;

            isAdd = (sum + isAdd ) / 10;

        }


        if (isAdd == 1) {
            ListNode  p = new ListNode(isAdd);
            p.next = cur;
            cur = p;
        }

        return cur;

    }


    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();

        ListNode cur1 = l1;
        ListNode cur2 = l2;

        while(cur1 != null) {
            stack1.push(cur1.val);
            cur1 = cur1.next;
        }

        while (cur2 != null) {
            stack2.push(cur2.val);
            cur2 = cur2.next;
        }

        int isAdd = 0;

        while(!stack1.isEmpty() || !stack2.isEmpty()) {

            int sum = (stack1.isEmpty() ? 0 : stack1.pop())
                    + (stack2.isEmpty() ? 0 : stack2.pop());

            if (sum + isAdd >= 10) {
                stack3.push(sum + isAdd - 10);
                isAdd = 1;

            } else {
                stack3.push(sum + isAdd);
                isAdd = 0;
            }
        }

        if (isAdd == 1) stack3.push(1);


        ListNode dummy = new ListNode(0);
        ListNode p = dummy;

        while(!stack3.isEmpty()) {
            p.next = new ListNode(stack3.pop());
            p = p.next;
        }

        return dummy.next;
    }




}
