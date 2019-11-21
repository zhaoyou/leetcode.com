package binarysearch;

/**
 * reference
 * https://leetcode.com/problems/find-k-th-smallest-pair-distance/discuss/109082/Approach-the-problem-using-the-%22trial-and-error%22-algorithm
 */
public class FindKthSmallestPairDistance {

    /**
     * 利用桶排序的原理,根据元素的最大值，建立对应的桶数量， 把两个点的距离出现的次数保存起来。
     * 然后一个个去比较找到第K小的距离
     * @param nums
     * @param k
     * @return
     */
    public int smallestDistancePair(int[] nums, int k) {
        int LEN = 1000000;

        int[] dp = new int[LEN];
        int size = nums.length;

        for(int i = 0; i < size; i++) {
            for(int j = i + 1; j < size; j++) {
                dp[Math.abs(nums[i] - nums[j])]++;
            }
        }

        for(int i = 0; i < LEN; i++) {

            if (dp[i] >= k) return i;

            k -= dp[i];

        }

        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3,};
    }
}
