package top100;

import binarytree.TreeNode;

import java.util.*;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {

        if (root == null) return Collections.emptyList();

        List<Integer> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {

            int size = queue.size();

            for (int i = size; i > 0; i--) {
                TreeNode node = queue.poll();
                if (i == size) list.add(node.val);

                if (node.right != null) queue.add(node.right);
                if (node.left != null) queue.add(node.left);
            }
        }

        return list;
    }

}
