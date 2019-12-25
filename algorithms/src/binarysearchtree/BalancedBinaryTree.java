package binarysearchtree;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * https://leetcode.com/problems/balanced-binary-tree/discuss/35691/The-bottom-up-O(N)-solution-would-be-better
 */
public class BalancedBinaryTree {


    public boolean isBalanced2(TreeNode root) {
        return helper(root) != -1;
    }


    private int helper(TreeNode root) {

        if (root == null) return 0;

        int left = helper(root.left);

        if (left == -1)
            return -1;

        int right = helper(root.right);

        if (right == -1)
            return -1;

        if (Math.abs(left - right) > 1)
            return -1;

        return Math.max(left, right) + 1;
    }




    public boolean isBalanced(TreeNode root) {

        if (root == null) return true;


        int l = getHeight(root.left);
        int r = getHeight(root.right);

        //System.out.println(root.val + "  ---> result: " + Math.abs(l-r));

        if (Math.abs((l -r)) > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * 获取每个节点的到叶子节点的最大高度
     * @param node
     * @return
     */
    private int getHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = getHeight(node.left) + 1;
        int rightHeight = getHeight(node.right) + 1;

        return Math.max(leftHeight, rightHeight);
    }

    @Test
    public void test() {

        TreeNode root = new TreeNode(3);

        TreeNode leftNode = new TreeNode(5);
        TreeNode rightNode = new TreeNode(1);

        root.right = rightNode;
        root.left = leftNode;



        TreeNode t56 = new TreeNode(6);
        TreeNode t52 = new TreeNode(2);

        leftNode.left = t56;
        leftNode.right = t52;

        TreeNode t27 = new TreeNode(7);
        TreeNode t24 = new TreeNode(4);

        t52.left = t27;
        t52.right = t24;






        TreeNode leftNode2 = new TreeNode(0);
        TreeNode rightNode2 = new TreeNode(8);

        rightNode.left = leftNode2;
        rightNode.right = rightNode2;


        //System.out.println(isBalanced(root));

//        System.out.println(getHeight(leftNode));
//        System.out.println(getHeight(rightNode));


        Date d = new Date();
        Calendar c = Calendar.getInstance();

        int h = c.get(Calendar.HOUR_OF_DAY);

        int y = c.get(Calendar.DAY_OF_YEAR);

        int m = c.get(Calendar.DAY_OF_MONTH);


        int mm  = c.get(Calendar.MINUTE);

        System.out.println(mm);


        System.out.println(d.getTime());


        System.out.println("y: " + y + " m: " + m + " h:" + h);

    }

}
