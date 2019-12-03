package arrayandstring;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {

        List<Integer> list = new ArrayList<>();

        int i = 0;

        while (i < rowIndex + 1) {

            list.add(0, 1);

            int j = 1;
            while(j < i) {
                list.set(j, list.get(j) + list.get(j + 1));
                j++;
            }
            i++;
        }

        return list;
    }

    @Test
    public void test() {
        System.out.println(getRow(0));
        System.out.println(getRow(1));
//
        System.out.println(getRow(2));

        System.out.println(getRow(3));

        System.out.println(getRow(4));

    }
}
