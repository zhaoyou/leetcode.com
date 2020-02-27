package recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {


        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i <= rowIndex; i++) {
            list.add(helper(rowIndex, i, map));
        }

        return list;
    }

    private int helper(int rowIndex, int colIndex, Map<String, Integer> map) {


        if (colIndex == 0 || rowIndex == colIndex) return 1;

        String key = rowIndex + ":" + colIndex;
        if (map.containsKey(key)) return map.get(key);

        int result =  helper(rowIndex - 1, colIndex -1, map)
                + helper(rowIndex - 1, colIndex, map);

        map.put(key, result);

        return result;
    }

    @Test
    public void test() {
        int rowIndex = 5;
        System.out.println(getRow(rowIndex));
    }
}
