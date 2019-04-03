package interviewMedium.Tree;

import org.junit.Test;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {

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

        System.out.println(zigzagLevelOrder(node1));

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {


        List<List<Integer>> list = new ArrayList<>();

        if (root == null) return list;


        ArrayDeque<TreeNode> queue = new ArrayDeque<>();

        boolean zigzag = false;

        queue.add(root);

        while(!queue.isEmpty()) {

            int size = queue.size();

            List<Integer> subList = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (!zigzag) subList.add(node.val);
                else subList.add(0, node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }


            zigzag = !zigzag;

            list.add(subList);
        }

        return list;
    }
}
