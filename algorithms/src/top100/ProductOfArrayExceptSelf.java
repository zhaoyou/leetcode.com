package top100;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int res[] = new int[len];

        // 计算当前值的左边部分乘积
        for(int i = 0; i < len; i++) {
            if (i == 0) res[i] = 1;
            else res[i] = res[i] * nums[i - 1];
        }

        // 计算右边的部分的乘积
        int right = 1;
        for(int j = len - 1; j >= 0; j--) {
            res[j] = res[j] * right;
            right *= res[j];
        }

        return res;
    }


}
