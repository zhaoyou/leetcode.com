package bst;

import org.junit.Test;

/**
 * reference:
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/discuss/286725/JavaC++Python-Revered-Inorder-Traversal
 */
public class BinarySearchTreeToGreaterSumTree {

    @Test
    public void test() {
        TreeNode root = new TreeNode(4);

        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);

        TreeNode node0 = new TreeNode(0);
        TreeNode node2 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);

        TreeNode node3 = new TreeNode(3);
        TreeNode node8 = new TreeNode(8);

        root.left = node1;
        root.right = node6;

        node1.left = node0;
        node1.right = node2;

        node2.right = node3;

        node6.left = node5;
        node6.right = node7;

        node7.right = node8;



        bstToGst(root);

        System.out.println(root);

    }

    private int sum = 0;


    public TreeNode bstToGst(TreeNode root) {
        helper(root, 0);
        return root;
    }

    private int helper(TreeNode node, int sum) {
            if (node == null) return sum;
            sum = helper(node.right, sum);
            sum = node.val = node.val + sum;
            sum = helper(node.left, sum);
            return sum;
    }

    public TreeNode bstToGst2(TreeNode root) {
        helper(root);
        return root;
    }

    private void helper(TreeNode node) {
        if (node == null) return;
        helper(node.right);
        sum = node.val = node.val + sum;
        helper(node.left);
    }
}
