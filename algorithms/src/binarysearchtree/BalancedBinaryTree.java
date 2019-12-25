package binarysearchtree;

import org.junit.Test;

/**
 * https://leetcode.com/problems/balanced-binary-tree/discuss/35691/The-bottom-up-O(N)-solution-would-be-better
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {

        if (root == null) return true;


        int l = getHeight(root.left);
        int r = getHeight(root.right);

        //System.out.println(root.val + "  ---> result: " + Math.abs(l-r));

        if (Math.abs((l -r)) > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = getHeight(node.left) + 1;
        int rightHeight = getHeight(node.right) + 1;

        return Math.max(leftHeight, rightHeight);
    }

    @Test
    public void test() {

        TreeNode root = new TreeNode(3);

        TreeNode leftNode = new TreeNode(5);
        TreeNode rightNode = new TreeNode(1);

        root.right = rightNode;
        root.left = leftNode;



        TreeNode t56 = new TreeNode(6);
        TreeNode t52 = new TreeNode(2);

        leftNode.left = t56;
        leftNode.right = t52;

        TreeNode t27 = new TreeNode(7);
        TreeNode t24 = new TreeNode(4);

        t52.left = t27;
        t52.right = t24;






        TreeNode leftNode2 = new TreeNode(0);
        TreeNode rightNode2 = new TreeNode(8);

        rightNode.left = leftNode2;
        rightNode.right = rightNode2;


        //System.out.println(isBalanced(root));

        System.out.println(getHeight(leftNode));
        System.out.println(getHeight(rightNode));




    }

}
