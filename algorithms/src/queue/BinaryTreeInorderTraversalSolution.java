package queue;


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversalSolution {
    public List<Integer> inorderTraversal(TreeNode root) {

        if (root == null) return null;

        List<Integer> list = new LinkedList<>();

        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;

        while(!stack.isEmpty() || cur != null) {

                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }

                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;

        }

        return list;
    }
}
