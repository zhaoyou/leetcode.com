package Sum3Closest;

import java.util.Arrays;

public class Sum3Closest {
    public static void main(String[] args) {
        int [] nums = {1,2,5,10,11};
        int target = 12;
        System.out.println(threeSumClosest(nums, target));
    }

    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        display(nums);

        int closestValue = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;

            System.out.println(" outloop: i" + i);
            
            while (start < end) {

                int sum = nums[i] + nums[start] + nums[end];

                if (sum > target) {
                    //System.out.println(" more than target: " + nums[i] + " " + nums[start] + " " +  nums[end]);

                    // two numbers all more than target
                    if (closestValue > target) {
                        if (sum < closestValue) closestValue = sum;
                    } else { // sum more than target, closeestValue less than target
                        if (Math.abs(sum - target) < Math.abs(closestValue - target))
                            closestValue =  sum;
                    }

                    //System.out.println("closestValue: " + closestValue);
                    
                    end--;
                }

                if (sum < target) {
                    //System.out.println(" less than target: " + nums[i] + " " + nums[start] + " " +  nums[end]);

                    // two numbers all less than target
                    if (closestValue < target) {
                            if (sum > closestValue) closestValue = sum;
                    } else { // sum less than target , closestValue more than target
                        if (Math.abs(sum - target) < Math.abs(closestValue - target))
                            closestValue =  sum;
                    }

                    //System.out.println("closestValue: " + closestValue);

                    start ++;
                }

                if (sum == target) {
                    return sum;
                }
            }
        }

        return closestValue;
    }

    public static void display(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            System.out.print(" "+ nums[i]);
        }
        System.out.println();
    }
}