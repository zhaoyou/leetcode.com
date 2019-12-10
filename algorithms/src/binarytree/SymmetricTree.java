package binarytree;

import java.util.Stack;

/**
 * reference
 * https://leetcode.com/problems/symmetric-tree/discuss/33054/Recursive-and-non-recursive-solutions-in-Java
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return root == null || helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }

        if (left.val != right.val) return false;

        return helper(left.left, right.right) && helper(left.right, right.left);
    }

    public boolean isSymmetric2(TreeNode root) {

        if (root == null) return true;

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root.left);
        stack.push(root.right);

        while (!stack.isEmpty()) {
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();

            if (left == null && right == null) continue;

            if (left == null || right == null || left.val != right.val) return false;

            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }

        return true;
    }
}
