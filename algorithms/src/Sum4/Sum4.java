package Sum4;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

public class Sum4 {
    public static void main(String[] args) {
        int[] nums = {2, 1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(fourSum(nums, target));
    }


    
    public static  List<List<Integer>> fourSum(int[] nums, int target) {
            
        Arrays.sort(nums);

        Set<List<Integer>> set = new HashSet();

        display(nums);

        for(int i = 0; i < nums.length - 3; i++) {
            int start1 = i + 1;
            int start2 = i + 2;
            int end = nums.length - 1;

            while(start1 < end - 1) {

                while(start2 < end) {

                    int sum = nums[i] + nums[start1] + nums[start2] + nums[end];
    
                    if (sum == target) {
                        List<Integer> subList = new ArrayList();

                        subList.add(nums[i]);
                        subList.add(nums[start1]);
                        subList.add(nums[start2]);
                        subList.add(nums[end]);
                        set.add(subList);
    
                        end -=1;
                    }
    
                    if (sum < target) {
                        start2 += 1;
                    }
    
                    if (sum > target) {
                        end -= 1;
                    }
                }

                start1 += 1;
                start2 = start1 + 1;
                end  =  nums.length - 1;

            }

            
        }

        return new ArrayList(set);
    }

    public static void display(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
    
}