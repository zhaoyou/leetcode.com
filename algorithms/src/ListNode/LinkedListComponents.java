package ListNode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * reference: http://www.cnblogs.com/grandyang/p/9601243.html
 */
public class LinkedListComponents {

    @Test
    public void test() {

        ListNode h1 = new  ListNode(0);
        h1.next = new  ListNode(1);
        h1.next.next = new  ListNode(2);
        h1.next.next.next = new  ListNode(3);
        h1.next.next.next.next = new  ListNode(4);

        int [] g = {0, 3, 1, 4};

        System.out.println(numComponents(h1, g));
    }


    public int numComponents(ListNode head, int[] G) {

        Set<Integer> set = new HashSet<>();
        for (int g: G) set.add(g);

        int i = 0;

        while(head != null) {
            if (set.contains(head.val) && (head.next == null || !set.contains(head.next.val))) {
                i++;
            }

            head = head.next;
        }

        return i;
    }
}
