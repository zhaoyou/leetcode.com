package interviewEasy.Tree;


import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +

                '}';
    }
}

public class ValidateBinarySearchTree {


    public boolean isValidBST(TreeNode root) {

        if (root == null) return true;

        Stack<TreeNode> stack = new Stack();

        TreeNode prev = null;

        while(root != null || !stack.isEmpty()) {

            while(root != null) {
                stack.add(root);
                root = root.left;
            }

            root = stack.pop();

            if (prev != null && root.val <= prev.val) return false;

            prev = root;

            root = root.right;

        }


        return true;
    }
}
