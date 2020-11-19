package binarytree;

public class DiameterOfBinaryTree {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        findLongestSinglePath(root);
        return max;
    }

    private int findLongestSinglePath(TreeNode node) {
        if (node == null) return 0;

        int left = findLongestSinglePath(node.left);
        int right = findLongestSinglePath(node.right);

        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }
}
