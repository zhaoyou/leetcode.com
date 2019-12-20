package binarysearchtree;


import org.junit.Test;

import java.util.Stack;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/discuss/32112/Learn-one-iterative-inorder-traversal-apply-it-to-multiple-tree-questions-(Java-Solution)
 * https://leetcode.com/problems/validate-binary-search-tree/discuss/32141/C++-simple-recursive-solution
 */
public class ValidateBinarySearchTreeSolution {


    public boolean isValidBST2(TreeNode root) {
        return helper(root, null, null);
    }


    /**
     * 其实这个min 和 max 就是为了限制当前节点的范围
     * @param root
     * @param min
     * @param max
     * @return
     */
    private boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null ) return true;
        if ((min != null && min >= root.val) || (max != null && max <= root.val)) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while(cur != null || !stack.isEmpty()) {
                while(cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                if (prev != null && cur.val <= prev.val) return false;
                prev = cur;

                cur = cur.right;
        }

        return true;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(2);

        TreeNode leftNode = new TreeNode(1);
        TreeNode rightNode = new TreeNode(3);

        root.right = rightNode;
        root.left = leftNode;



        TreeNode t56 = new TreeNode(6);
        TreeNode t52 = new TreeNode(2);

//        leftNode.left = t56;
//        leftNode.right = t52;

        TreeNode t27 = new TreeNode(7);
        TreeNode t24 = new TreeNode(4);

//        t52.left = t27;
//        t52.right = t24;





//
//        TreeNode leftNode2 = new TreeNode(0);
//        TreeNode rightNode2 = new TreeNode(8);
//
//        rightNode.left = leftNode2;
//        rightNode.right = rightNode2;


        System.out.println(isValidBST2(root));


    }



}
