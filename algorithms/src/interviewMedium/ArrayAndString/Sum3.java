package interviewMedium.ArrayAndString;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3 {

    @Test
    public void test() {
        int[] num = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(num));
    }

    public List<List<Integer>> threeSum(int[] num) {
        if (num == null || num.length < 3) return null;
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(num);

        for(int i = 0; i < num.length; i++) {

            if (num[i] > 0) break;
            if (i > 0 && num[i] == num[i - 1]) continue;

            int target = 0 - num[i];

            int left = i + 1;
            int right = num.length - 1;

            while(left < right) {
                if (num[left] + num[right] == target) {

                    list.add(Arrays.asList(num[i], num[left], num[right]));

                    while(left < right && num[left] == num[left + 1]) left++;
                    while(left < right && num[right] == num[right -1]) right--;

                    left++;
                    right--;
                } else if (num[left] + num[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return list;
    }
}
