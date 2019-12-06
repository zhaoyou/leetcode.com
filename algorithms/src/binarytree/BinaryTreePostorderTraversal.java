package binarytree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if (root != null) {
            if (root.left != null) helper(root.left, list);
            if (root.right != null) helper(root.right, list);
            list.add(root.val);
        }
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);

        TreeNode rightNode = new TreeNode(2);

        TreeNode leftNode = new TreeNode(3);

        root.right = rightNode;
        rightNode.left = leftNode;

        System.out.println(postorderTraversal(root));

    }
}
