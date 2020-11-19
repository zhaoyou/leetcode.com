package binarytree;

import java.util.Stack;


/**
 * 递归； DFS； BFS 不同的方式
 * reference: https://leetcode.com/problems/invert-binary-tree/discuss/62707/Straightforward-DFS-recursive-iterative-BFS-solutions
 */
class  InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        
        if (root == null) return null;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

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
