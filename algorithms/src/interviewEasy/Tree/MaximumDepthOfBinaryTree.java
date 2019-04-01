package interviewEasy.Tree;

import TreeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {


    public int maxDepth(TreeNode root) {

        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
