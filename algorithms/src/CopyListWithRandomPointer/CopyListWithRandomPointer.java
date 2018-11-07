package CopyListWithRandomPointer;

import RandomListNode.RandomListNode;
import org.junit.Test;

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
}
