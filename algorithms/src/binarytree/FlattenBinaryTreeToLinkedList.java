package binarytree;

import java.util.Stack;

import javax.swing.tree.TreeNode;

/**
 * reference: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/discuss/36977/My-short-post-order-traversal-Java-solution-for-share
 * 
 */
public class FlattenBinaryTreeToLinkedList {

    TreeNode next = null;

    /**
     * 采用递归方式
     */
    public void flatten(TreeNode root) {

        if (root == null) return ;

        flatten(root.right);
        flatten(root.left);

        root.right = next;
        root.left = null;

        next = root;

    }


    public void flatten2(TreeNode root) {

        while(root != null) {

            /**
             * 想办法把root的左边转移到右边节点，为了腾空间右节点，需要先把右节点放到左边的最后一个节点下
             */
            if (root.left != null) {

                TreeNode p = root.left;

                while(p.right != null) p = p.right;

                p.right = root.right;

                root.right = root.left;

                root.left = null;

            }

            root = root.right;

        }
    }
}