package binarytree;

import java.util.Stack;


public class MergeTwoBinaryTrees {

    /**
     * like this: https://leetcode.com/problems/merge-two-binary-trees/discuss/104299/Java-Solution-6-lines-Tree-Traversal
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        
        TreeNode left = mergeTrees(t1.left, t2.left);
        TreeNode right = mergeTrees(t1.right, t2.right);

        TreeNode node = new TreeNode(t1.val + t2.val);
        node.left = left;
        node.right = right;

        return node;
    }

    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        
        if (t1 == null) return t2;

        Stack<TreeNode[]> stack = new Stack<>();

        stack.push(new TreeNode[]{t1, t2});

        while(!stack.isEmpty()) {
            TreeNode[] t = stack.pop();

            if (t2 == null) continue;

            t1.val += t2.val;

            if (t1.left == null) {
                t1.left = t2.right;
            } else {
                stack.push(new TreeNode[]{t1.left, t2.left});
            }

            if (t1.right == null) {
                t1.right = t2.right;
            } else {
                stack.push(new TreeNode[]{t1.right, t2.right});
            }
        }

        return t1;


    }
}