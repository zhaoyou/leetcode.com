package binarytree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) return list;

        stack.add(root);

        while(!stack.isEmpty()) {

            TreeNode node = stack.pop();

            list.add(0, node.val);

            if (node.left != null) {stack.push(node.left);}

            if (node.right !=null) { stack.push(node.right);}
        }
        return list;
    }


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

       // System.out.println(postorderTraversal(root));
        System.out.println(postorderTraversal2(root));

    }
}
