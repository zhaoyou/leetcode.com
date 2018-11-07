package ListNode;

import org.junit.Test;


/**
 * reference: http://www.cnblogs.com/grandyang/p/7878548.html
 *
 * 代码量牛逼的实现
 */
public class SplitLinkedListInParts {

    @Test
    public void test() {
        ListNode h1 = new  ListNode(1);
        h1.next = new  ListNode(2);
        h1.next.next = new  ListNode(3);
        h1.next.next.next = new  ListNode(4);
        h1.next.next.next.next = new  ListNode(5);
        int k = 5;

        //display(splitListToParts(h1, k));

        ListNode head = new  ListNode(1);
        head.next = new  ListNode(2);
        head.next.next = new  ListNode(3);
        head.next.next.next = new  ListNode(4);
        head.next.next.next.next = new  ListNode(5);
        head.next.next.next.next.next = new  ListNode(6);
        head.next.next.next.next.next.next = new  ListNode(7);
        head.next.next.next.next.next.next.next = new  ListNode(8);

        head.next.next.next.next.next.next.next.next = new  ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new  ListNode(10);

        int k2 = 4 ;

        display(splitListToParts(head, k2));

    }

    private void display(ListNode[] arr) {
        for(ListNode node: arr) {
            System.out.println(node);
        }
    }


    public ListNode[] splitListToParts(ListNode root, int k) {

        if (root == null) return new ListNode[k];

        if (k == 0) return new ListNode[] {root};

        int len = getCount(root);

        // k 大于等于List节点个数
        if (k >= len) { return lessK(root, k); }



        ListNode[] result = new ListNode[k];

        int mod = len % k;
        int subLen = len / k;


        //System.out.println("len: " + len + " mod : " + mod + " array len: " + len/k);

        int index = 0; // 数组索引
        int index_k = 1;
        int mod_index = 0; // 剩余的数据平均分配到前几个队列的索引

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode prev = dummy;

        ListNode cur = root;

        while(cur != null) {

            ListNode next = cur.next;

            if (index_k < subLen) {  // 满足一个subList
                //System.out.println("index_k < k");
                prev.next = cur;
                prev = prev.next;

                index_k ++ ;

            }  else {           // index_k = subLen 满足sublist长度。

                //System.out.println("index_K == k");

                prev.next = cur;
                prev = prev.next;

                if (mod != 0 && mod_index < mod) { // 需要在前面部分多一个元素，且元素未添加完毕


                    //System.out.println("还需要 mod index: " + mod_index);

                    cur = next;
                    next = cur.next;


                    prev.next = cur;
                    prev = prev.next;



                    mod_index++;


                    if (mod_index == mod) mod = 0; // 表示不再需要额外追加元素
                }

                cur.next = null;



                //System.out.println("添加到数组");

                // 添加元素
                result[index++] = dummy.next;

                dummy = new ListNode(0);
                prev = dummy;


                index_k = 1; // 当个sublist完成，重置为0

            }

            cur = next;
        }

        return result;
    }

    private ListNode[] lessK(ListNode root, int k ) {
        ListNode[] result = new ListNode[k];

        int i = 0;

        while(root != null) {
            result[i++] = root;
            ListNode next = root.next;
            root.next = null;
            root = next;
        }

        while(i < k) { result[i++] = null; }

        return result;

    }

    /**
     * 获取List的节点个数
     * @param root
     * @return
     */
    private int getCount(ListNode root) {
        ListNode cur = root;
        int i = 0;
        while(cur != null) {
            cur = cur.next;
            i++;
        }
        return i;
    }
}
