package String;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * Given a list of 24-hour clock time points in "Hour:Minutes" format,
 * find the minimum minutes difference between any two time points in the list.
 *
 * Example 1:
 * Input: ["23:59","00:00"]
 * Output: 1
 *
 * Note:
 * The number of time points in the given list is at least 2 and won't exceed 20000.
 * The input time is legal and ranges from 00:00 to 23:59.
 *
 */

/**
 * reference: http://www.cnblogs.com/grandyang/p/6568398.html
 */
public class MinimumTimeDifference {

    @Test
    public void test() {
        List<String> list = new ArrayList<String>();
        list.add("03:00");
        list.add("05:00");
        list.add("12:00");
        System.out.println(findMinDifference(list));

    }


    public int findMinDifference(List<String> timePoints) {
        int [] arr = new int[1440];

        for(String timePoint: timePoints) {
            Integer index = getMinutes(timePoint);
            if (arr[index] != 0) return 0;
            arr[index] = 1;
        }



        int min = 720;
        int firstIndex = 0;
        boolean isFirst = false;

        int prev = -1;

        for(int i = 0 ; i < arr.length; i++) {

            if (arr[i] == 0) continue;

            if (!isFirst) {
                firstIndex = i;     // 第一个
                prev = i;           // 前一个
                isFirst = true;
            }

            int start = i;
            int k = i + 1;

            while(k < arr.length && arr[k] == 0) {
                k++;
            }

            if (k == arr.length)  {
                min = Math.min(min, Math.min(start - prev, 1440 - start + firstIndex));
            } else {
                // 如果 start == prev 代表还是第一个点的开始，不需要计算当前点和前一个点的距离。在上面
                // if 里面如果是最后一个点，计算了从0开始的具体。720  可以为任意大于题目的两个长度的具体720即可
                min = Math.min(min, Math.min(k - start, start == prev ? 720 : start - prev));
            }

            i = k-1;

        }
        return min;
    }

    private Integer getMinutes(String time) {
        String[] arr = time.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }

}
