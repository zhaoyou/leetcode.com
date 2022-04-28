package top100;


import binarytree.*;

public class BinaryTreeMaximumPathSum {

    int MAX = Integer.MIN_VALUE;


    public int maxPathSum(TreeNode root) {
        helper(root);
        return MAX;
    }

    public int helper(TreeNode root) {
        if (root == null) return 0;

        int left = helper(root.left);
        int right  = helper(root.right);

        int childMax = Math.max(left, right);
        

        // 获取当前节点为root节点时，最大的路径 = 当前节点 + （左边 或 右边 或者 都不加）
        MAX = Math.max(Math.max(left + right + root.val, Math.max(childMax + root.val,  root.val)), MAX);
        
        //System.out.println("root:" + root.val + " childMax: " + childMax + " MAX:" + MAX);
        
        // 返回上去节点的最大值时，则只能选择左节点或者右节点或者都不选择。和上面唯一不同就是不能选择左右节点都选择。（因为那样就不是一条线了）

        return Math.max(root.val, Math.max(left + root.val, right + root.val));
    }

}
