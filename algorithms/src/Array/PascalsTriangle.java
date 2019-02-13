package Array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 *
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class PascalsTriangle {


    @Test
    public void test() {
        List<List<Integer>> list = generate(10);
        for(List l: list) {
            System.out.println(l);
        }
    }

    public List<List<Integer>> generate(int numRows) {


        List<List<Integer>> list = new ArrayList<>();

        if (numRows == 0) return list;
        if (numRows == 1) return Arrays.asList(Arrays.asList(1));

        list.add(Arrays.asList(1));

        for(int i = 2; i <= numRows; i++) {
            List<Integer> subList = new ArrayList<>();
            List<Integer> prevList = list.get(list.size() - 1);
            for(int j = 0; j < i; j++) {
                if (j == 0) {
                    subList.add(1);
                } else if (j < i - 1) {
                    subList.add(prevList.get(j - 1) + prevList.get(j));
                } else {
                    subList.add(1);
                }
            }

            list.add(subList);
        }
        return list;
    }
}
