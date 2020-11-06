package binarytree;

import java.util.Stack;

import javax.swing.tree.TreeNode;

/**
 * 递归； DFS； BFS 不同的方式
 * reference: https://leetcode.com/problems/invert-binary-tree/discuss/62707/Straightforward-DFS-recursive-iterative-BFS-solutions
 */
public class  InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        
        if (root == null) return null;

        int left = invertTree(root.left);
        int right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;

        Stack<TreeNode> stack = new Stack();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();

            TreeNode left = cur.left;
            cur.left = cur.right;
            cur.right = left;

            if (cur.left != null) {
                stack.push(cur.left);
            }

            if (cur.right != null) {
                stack.push(cur.right);
            }
        }

        return root;
    }


}
