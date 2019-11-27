package arrayandstring;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * reference:
 * https://leetcode.com/problems/pascals-triangle/discuss/38141/My-concise-solution-in-Java
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        if (numRows == 0) return list;

        list.add(new ArrayList<>(Arrays.asList(1))); // 添加第一个
        if (numRows == 1) {
            return list;
        }

        for(int i = 1; i < numRows; i++) {
            List<Integer> subList = new ArrayList<>();
            subList.add(1);

            List<Integer> prevList = list.get(i - 1);
            for(int j = 1; j < i; j++) {
                subList.add(prevList.get(j - 1) + prevList.get(j));
            }

            subList.add(1);

            list.add(subList);
        }

        return list;
    }

    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        List<Integer> row = new ArrayList<>(); // 公用一个list

        for(int i = 0; i < numRows; i++) {

            row.add(0, 1);  // 插入首部0，然后后面依次计算 j

            for(int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }

            list.add(new ArrayList<>(row));
        }

        return list;
    }

    @Test
    public void test() {
        System.out.println(generate(1));
        System.out.println(generate2(1));

        System.out.println(generate(2));
        System.out.println(generate2(2));

        System.out.println(generate(3));
        System.out.println(generate2(3));

        System.out.println(generate(4));
        System.out.println(generate2(4));

        System.out.println(generate(5));
        System.out.println(generate2(5));

    }
}
