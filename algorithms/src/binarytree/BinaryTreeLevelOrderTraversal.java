package binarytree;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/discuss/33450/Java-solution-with-a-queue-used
 */
public class BinaryTreeLevelOrderTraversal {


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();

        if (root == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()) {
            List<Integer> sub = new LinkedList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sub.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            list.add(sub);
        }

        return list;
    }


    @Test
    public void test() {
        TreeNode root = new TreeNode(3);

        TreeNode leftNode = new TreeNode(9);
        TreeNode rightNode = new TreeNode(20);

        TreeNode leftNode2 = new TreeNode(15);
        TreeNode rightNode2 = new TreeNode(7);

        root.right = rightNode;
        root.left = leftNode;

        rightNode.right = rightNode2;
        rightNode.left = leftNode2;

        System.out.println(levelOrder(root));
    }
}
