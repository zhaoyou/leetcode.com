package binarytree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * reference
 * https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45551/Preorder-Inorder-and-Postorder-Iteratively-Summarization
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) return list;

        TreeNode cur = root;

        while(cur != null || !stack.isEmpty()) {
            if (cur != null) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
            } else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        helper(root, list);
        return list;
    }

    private void helper(TreeNode node, List<Integer> list) {
        if (node != null) {
            helper(node.left, list);
            list.add(node.val);
            helper(node.right, list);
        }
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);

        TreeNode rightNode = new TreeNode(2);

        TreeNode leftNode = new TreeNode(3);

        root.right = rightNode;
        rightNode.left = leftNode;

         System.out.println(inorderTraversal(root));

    }

}
