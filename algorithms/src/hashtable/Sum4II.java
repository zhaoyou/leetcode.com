package hashtable;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Sum4II {

    @Test
    public void test() {
        int[] A = { 1, 2};
        int[] B = {-2,-1};
        int[] C = {-1, 2};
        int[] D = {0, 2};

        System.out.println(fourSumCount(A, B, C, D));
    }


    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n  = A.length;
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1); // 统计A + B 两两的和出现的次数
            }
        }


        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int sum = C[i] + D[j];

                res += map.getOrDefault(-1 * sum, 0); // 根据 C + D 的结果
            }
        }

        return res;
    }
}
