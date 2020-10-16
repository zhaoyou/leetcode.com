package ListNode;

import ListNode.RandomListNode;

import java.util.HashMap;
import java.util.Map;


/**
 * reference:
 * http://www.cnblogs.com/grandyang/p/4261431.html
 *
 * 特别的方式实现参考： http://fisherlei.blogspot.com/2013/11/leetcode-copy-list-with-random-pointer.html
 */
public class CopyListWithRandomPointer {


    public RandomListNode copyRandomList(RandomListNode head) {


        // 存放旧列表中的每一Node对应copy之后新的Node。方便第二次循环获取到。
        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode res = new RandomListNode(0);
        RandomListNode p = res;

        RandomListNode cur = head;

        while(cur != null) {
            RandomListNode temp = new RandomListNode(cur.label);

            map.put(cur, temp);

            p.next = temp;

            p = p.next;

            cur = cur.next;

        }


        cur = head;

        p = res.next;

        while(cur != null) {

            RandomListNode random = map.get(cur.random);

            p.random = random;

            p = p.next;

            cur = cur.next;
        }


        return res.next;

    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Node cur = head;

        Node newNode = new Node(1);
        Node p = newNode;

        Map<Node, Node> map = new HashMap<>();

        while(cur != null) {

            Node n = new Node(cur.val);

            p.next = n;

            map.put(cur, p);

            p = p.next;
            cur = cur.next;
        }

        p = newNode.next;
        cur = head;

        while(cur != null) {

            System.out.println(map.containsKey(cur.random) + " " );

            if (map.containsKey(cur.random)) {
                System.out.println("random: " + cur.random.val);
            }
            p.random = map.get(cur.random);

            p = p.next;
            cur = cur.next;
        }

        return newNode.next;

    }
}
