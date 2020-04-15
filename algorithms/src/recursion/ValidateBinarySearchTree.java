package recursion;

import binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();

        double prev = - Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {

            while(root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if (root.val <= prev) return false;

            prev = root.val;

            root = root.right;
        }

        return true;
    }
}