package top100;

import binarytree.TreeNode;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/solution/
 */
public class KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {

        LinkedList<TreeNode> list = new LinkedList<>();

        while (true) {
            while(root != null) {
                list.add(root);
                root = root.left;
            }

            root = list.removeLast();

            if (--k == 0) return root.val;

            root = root.right;
        }

    }
}
