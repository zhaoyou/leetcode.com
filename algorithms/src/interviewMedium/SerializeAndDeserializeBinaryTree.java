package interviewMedium;



import apple.laf.JRSUIUtils;
import org.junit.Test;

import java.util.*;

public class SerializeAndDeserializeBinaryTree {
    @Test
    public void test() {

       TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode( 3);
        TreeNode node4 = new TreeNode( 4);
        TreeNode node5 = new TreeNode( 5);
        TreeNode node6 = new TreeNode( 6);
        TreeNode node7 = new TreeNode( 7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        
        //TreeNode node = new TreeNode(1);
        Codec c = new Codec();
        String s = c.serialize(node1);
//        String s2 = c.serialize2(node1);
        System.out.println(s);
        System.out.println(c.deserialize(s));
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                "\n, left=" + left +
                ", right=" + right +
                '}';
    }
}

class Codec {


    private static final String spliter = ",";
    private static final String NN = "X";




    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {


        StringBuffer sb = new StringBuffer();

        helper(root, sb);

        return sb.toString();
    }

    private void helper(TreeNode node, StringBuffer sb) {

        if (node == null) {
            sb.append(NN).append(spliter);
            return;
        } else {
            sb.append(node.val).append(spliter);
            helper(node.left, sb);
            helper(node.right, sb);
        }
    }



    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {


        Queue<String> queue = new ArrayDeque<>();

        queue.addAll(Arrays.asList(data.split(spliter)));

        return build(queue);
    }

    private TreeNode build(Queue<String> queue) {
        String s = queue.poll();
        if (s.equals(NN)) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.parseInt(s));

            node.left = build(queue);
            node.right = build(queue);
            return node;
        }
    }
}
