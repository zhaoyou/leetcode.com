package binarytree;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/discuss/74253/Easy-to-understand-Java-Solution
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) return "";

        stack.push(root);

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()) {

            TreeNode cur = stack.pop();

            if(cur == null) {
                sb.append("null,");
                continue;
            }

            sb.append(cur.val + ",");

            stack.add(cur.right);
            stack.add(cur.left);


        }

        return sb.toString().substring(0, sb.length() -1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data.equals("")) return null;

        Queue<String> queue = new LinkedList<>();

        queue.addAll(Arrays.asList(data.split(",")));

        return helper(queue);

    }

    public TreeNode helper(Queue<String> queue) {
        String val = queue.poll();
        if (val.equals("null")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = helper(queue);
        root.right = helper(queue);
        return root;
    }



    @Test
    public void test() {
        TreeNode root = new TreeNode(3);

        TreeNode leftNode = new TreeNode(5);
        TreeNode rightNode = new TreeNode(1);

        root.right = rightNode;
        root.left = leftNode;


//
//        TreeNode t56 = new TreeNode(6);
//        TreeNode t52 = new TreeNode(2);
//
//        leftNode.left = t56;
//        leftNode.right = t52;
//
//        TreeNode t27 = new TreeNode(7);
//        TreeNode t24 = new TreeNode(4);
//
//        t52.left = t27;
//        t52.right = t24;
//
//
//
//
//
//
//        TreeNode leftNode2 = new TreeNode(0);
//        TreeNode rightNode2 = new TreeNode(8);
//
//        rightNode.left = leftNode2;
//        rightNode.right = rightNode2;

        String str = serialize(root);

        System.out.println(str);

        TreeNode c = deserialize(str);

        System.out.println(c);

        System.out.println(serialize(c));


    }
}

