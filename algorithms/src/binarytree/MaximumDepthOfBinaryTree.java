package binarytree;

import org.junit.Test;

public class MaximumDepthOfBinaryTree {

    int MAX_DEPATH = 0;

    /**
     * bottom-Up
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);

        return Math.max(leftMax, rightMax) + 1;
    }

    public void maxDepth2(TreeNode root, int depth) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            MAX_DEPATH = Math.max(MAX_DEPATH, depth);
        }

        maxDepth2(root.left, depth + 1);
        maxDepth2(root.right, depth + 1);
    }


    @Test
    public void test() {
        TreeNode root = new TreeNode(3);

        TreeNode leftNode = new TreeNode(9);
        TreeNode rightNode = new TreeNode(20);

        TreeNode leftNode2 = new TreeNode(15);
        TreeNode rightNode2 = new TreeNode(7);

        root.right = rightNode;
        root.left = leftNode;

        rightNode.right = rightNode2;
        rightNode.left = leftNode2;

//        System.out.println(maxDepth(root));
        maxDepth2(root, 1);
        System.out.println(MAX_DEPATH);
    }



}
