package test;

import TreeNode.TreeNode;
import org.junit.Test;

public class TreeNodeTest {

    @Test
    public boolean theSame(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;

        if (p == null || q == null) return false;

        if (p.val != q.val) return  false;

        return theSame(p.left, q.left) && theSame(p.right, q.right);

    }
}
