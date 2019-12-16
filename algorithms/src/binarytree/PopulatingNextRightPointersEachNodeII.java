package binarytree;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/discuss/37828/O(1)-space-O(n)-complexity-Iterative-Solution
 */
public class PopulatingNextRightPointersEachNodeII {

    public Node connect(Node root) {
        Node cur = root;   // 当前遍历的节点
        Node head = null;  // 当前下一级节点的从左到右开始的第一个节点（方便下一个级别循环）
        Node prev = null;  // 当前下一级节点当前需要计算next的节点
        /**
         *           1
         *         /   \
         *        2     3
         *       / \   / \
         *      4  5  6   7
         *  
         */

        while(cur != null) {

            while(cur != null) {

                if (cur.left != null ) {

                    if (prev != null) {
                        prev.next = cur.left;
                    } else {
                        head = cur.left;
                    }

                    prev = cur.left;
                }

                if (cur.right != null) {

                    if (prev != null) {
                        prev.next = cur.right;
                    } else {
                        head = cur.right;
                    }

                    prev = cur.right;
                }

                cur = cur.next;
            }

            cur = head;
            head = null;
            prev = null;
        }
        return root;
    }

}

