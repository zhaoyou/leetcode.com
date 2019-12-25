package binarysearchtree;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end) return null;
        if (start == end) return new TreeNode(nums[start]);


        int rootIndex = start + (end - start ) / 2;

        TreeNode root = new TreeNode(nums[rootIndex]);

        root.left = helper(nums, start, rootIndex - 1);
        root.right = helper(nums, rootIndex + 1, end);

        return root;

    }
}
