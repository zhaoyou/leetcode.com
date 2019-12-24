package binarysearchtree;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/delete-node-in-a-bst/discuss/93296/Recursive-Easy-to-Understand-Java-Solution
 */
public class DeleteNodeInABST {
    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) return null;

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {

            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {


                TreeNode smallNode = root.right;

                while(smallNode.left != null) smallNode = smallNode.left;


                smallNode.left = root.left;

                return root.right;

            }

        }
        return root;
    }

    @Test
    public void test() {
        Queue<Integer> queue = new PriorityQueue<>(3);

        queue.offer(4);
        queue.offer(2);
        queue.offer(5);
        queue.offer(3);
        queue.offer(1);

        System.out.println(queue.size());
        System.out.println(queue.poll());
    }

}
