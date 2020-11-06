package binarytree;

public class MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;

        int val = (t1 != null ? t1.val : 0) + (t2 != null ? t2.val : 0);


        
        TreeNode left = mergeTrees(t1.left, t2.left);
        TreeNode right = mergeTrees(t1.right, t2.right);

        TreeNode node = new TreeNode(val);
        node.left = left;
        node.right = right;

    }
}