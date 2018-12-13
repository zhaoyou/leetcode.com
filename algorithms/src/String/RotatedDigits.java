package String;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * X is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different from X.  Each digit must be rotated - we cannot choose to leave it alone.
 *
 * A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 2 and 5 rotate to each other; 6 and 9 rotate to each other, and the rest of the numbers do not rotate to any other number and become invalid.
 *
 * Now given a positive number N, how many numbers X from 1 to N are good?
 *
 * Example:
 * Input: 10
 * Output: 4
 * Explanation:
 * There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
 * Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
 * Note:
 *
 * N  will be in range [1, 10000].
 */
public class RotatedDigits {

    @Test
    public void test() {
        int N = 10;
        System.out.println(N + " --> " + rotatedDigits(N));
    }

    public int rotatedDigits(int N) {
        Map<Integer, Integer> map = new HashMap();
        int i = 1;
        while(i <= N) {

            int a = i / 10;
            int y = i % 10;

            if (y == 3 || y == 4 || y == 7) {i++;continue;}


            if (map.containsKey(a)) {
                    if (y == 2 || y == 5 || y== 6 || y == 9)    // 直接添加
                        map.put(i, i);
                    else {

                       boolean b =  Pattern.compile("2|5|6|9").matcher(a+"").find(); // 之前包含非 0， 1， 8

                       if (b) { map.put(i, i); } else {
                          map.put(i, -1);
                       }

                    }
            } else if (i  < 10) {
                if (i == 2 || y == 5 || y == 6 || y == 9 || y == 1 || y == 8) {
                    map.put(i, i);
                }
            }

            i++;
        }

        map.remove(1);
        map.remove(8);

//        Integer[] cc = map.keySet().toArray(new Integer[0]);
//
//        Arrays.sort(cc);

        int res = 0;
        for(int key: map.keySet()) {
            if (map.get(key) != -1)  res++;
            //System.out.print(key + " \t");
        }

        //System.out.println("");


        return res;
    }

}
