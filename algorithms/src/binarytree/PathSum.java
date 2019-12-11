package binarytree;

import org.junit.Test;

/**
 * reference
 * https://leetcode.com/problems/path-sum/discuss/36378/AcceptedMy-recursive-solution-in-Java
 */
public class PathSum {


    public boolean hasPathSum2(TreeNode root, int sum) {

        if (root == null) return false;

        if (root.left == null && root.right == null ) return root.val == sum;  // 这里很巧妙

        return hasPathSum2(root.left, sum - root.val) || hasPathSum2(root.right, sum - root.val);
    }

    public boolean hasPathSum(TreeNode root, int sum) {

        return root != null && helper(root, sum, 0);
    }

    private boolean helper(TreeNode node, int sum, int total) {
        if (node.left == null && node.right == null) {
            if (total + node.val == sum) return true;
            else return false;
        } else {
            total += node.val;

            boolean flag1 = false;
            boolean flag2 = false;

            if (node.left != null) {
                flag1 = helper(node.left, sum, total);
            }
            if (node.right != null) {
                flag2 = helper(node.right, sum, total);
            }

            return flag1 || flag2;
        }
    }

    @Test
    public void test() {
        TreeNode root5 = new TreeNode(5);

        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);

        TreeNode node13 = new TreeNode(13);
        TreeNode node4_2 = new TreeNode(4);

        TreeNode node11 = new TreeNode(11);

        TreeNode node1 = new TreeNode(1);

        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);


        root5.left = node4;
        root5.right = node8;

        node8.right = node4_2;
        node8.left = node13;

        node4.left = node11;

        node11.left = node7;
        node11.right = node2;

        node4_2.right = node1;

        System.out.println(hasPathSum2  (root5, 26));
    }
}
