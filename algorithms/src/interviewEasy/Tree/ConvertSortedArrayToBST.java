package interviewEasy.Tree;

import org.junit.Test;

public class ConvertSortedArrayToBST {

    @Test
    public void test() {
        int[] nums = {-10,-3,0,5,9};
        System.out.println(sortedArrayToBST(nums));
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        TreeNode head =  helper(nums, 0, nums.length - 1);
        return head;
    }

    private TreeNode helper(int[] nums, int left, int right) {

        if (left > right) return null;

        int mid = left + (right - left) / 2;

        TreeNode node = new TreeNode(nums[mid]);

        node.left = helper(nums, left, mid - 1);
        node.right = helper(nums, mid + 1, right);

        return node;
    }




}
