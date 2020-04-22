package recursion;

import binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;

        if (p == null || q == null) return false;

        Queue<TreeNode> pQueue = new LinkedList<>();

        Queue<TreeNode> qQueue = new LinkedList<>();


        pQueue.add(p);

        qQueue.add(q);

        while( !pQueue.isEmpty()) {


            p = pQueue.poll();
            q = qQueue.poll();


            if (!isValid(p, q)) return false;

            if (p != null) {        // 有可能两个 p q 都是null

                if (!isValid(p.left, q.left)) return false;

                if (p.left != null) {     // 可能 p.left q.left both Null.
                    pQueue.add(p.left);
                    qQueue.add(q.left);
                }

                if (!isValid(p.right, q.right)) return false;

                if (p.right != null) {   // 可能 p.right q.right both Null.
                    pQueue.add(p.right);
                    qQueue.add(q.right);
                }
            }
        }

        return true;
    }

    private boolean isValid(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val;
    }
}
