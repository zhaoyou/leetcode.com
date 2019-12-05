package binarytree;


import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

    /**
     * 递归的方式实现 preOrder traversal
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        helper(root, list);
        return list;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            helper(root.left, list);
            helper(root.right, list);
        }
    }

    /**
     * 迭代的方式实现 preOrder traversal
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();

        if (root == null) return list;

        stack.push(root);

        while(!stack.isEmpty()) {

            TreeNode currentNode = stack.pop();

            list.add(currentNode.val);

            if (currentNode.right != null) stack.push(currentNode.right);
            if (currentNode.left != null) stack.push(currentNode.left);
        }

        return list;
    }






    @Test
    public void test() {
        TreeNode root = new TreeNode(1);

        TreeNode rightNode = new TreeNode(2);

        TreeNode leftNode = new TreeNode(3);

        root.right = rightNode;
        rightNode.left = leftNode;

        System.out.println(preorderTraversal2(root));

    }


}
