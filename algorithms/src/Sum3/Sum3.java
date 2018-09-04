package Sum3;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Sum3 {
    public static void main(String[] args) {
        int[] nums =  {-1, 0, 1, 2, -1, -4};
        //{1,2,-2,-1}
        System.out.println(threeSum2(nums));
    }

    /**
     * 三个循环，性能达不到要求
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        int min = Math.min(Math.min(nums[i], nums[j]), nums[k]);
                        int max = Math.max(Math.max(nums[i], nums[j]), nums[k]);
                        if (map.containsKey(min + "" + max)) continue;
                        List<Integer> list = new ArrayList();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        map.put(min + "" + max, max);
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }

    /**
     * 先排序，在利用指针位移判断。
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {

            int start = i + 1;
            int end = nums.length - 1;

            while( start < end) {
                if (nums[i] + nums[start] + nums[end] == 0) {
                    int min = Math.min(Math.min(nums[i], nums[start]), nums[end]);
                    int max = Math.max(Math.max(nums[i], nums[start]), nums[end]);
                    if (!map.containsKey(min + "" + max)) {
                        List<Integer> list = new ArrayList();
                        list.add(nums[i]);
                        list.add(nums[start]);
                        list.add(nums[end]);
                        result.add(list);
                        map.put(min + "" + max, max);
                    }
                    
                    end -=1;
                }

                if (nums[i] + nums[start] + nums[end] > 0) {
                    end -=1;
                }

                if (nums[i] + nums[start] + nums[end] < 0) {
                    start +=1;
                }
            }
        }
        return result;
    }

    /**
     * 
     * @param nums
     */
    public static void sort(int[] nums) {

    }
}