package String;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * reference:
 * https://zhuanlan.zhihu.com/p/33231348
 * http://www.cnblogs.com/grandyang/p/8799483.html
 */
public class ReorganizeString {

    @Test
    public void test() {
        String S = "aaab";
        System.out.println(S + " ---> \n" + reorganizeString(S));
    }


    public String reorganizeString(String S) {
        if (S.length() == 1) return S;

        int[] arr = new int[26];
        int len = S.length();

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        int max = 0;

        for(int i = 0; i < len; i++) {
            int c = S.charAt(i) - 97;

            arr[c] = arr[c] + 1;

            max = Math.max(max, arr[c]);

            if (max > (len + 1) / 2) return "";
        }

        for(int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                pq.add(new int[]{arr[i], 97 + i});
            }
        }


        StringBuffer sb = new StringBuffer();

        while(pq.size() >= 2) {
            int[] a1 = pq.poll();
            int[] a2 = pq.poll();

            sb.append((char)a1[1]);
            sb.append((char)a2[1]);

            if (--a1[0] > 0) pq.add(a1);
            if (--a2[0] > 0) pq.add(a2);
        }

        if (pq.size() > 0) sb.append((char)pq.poll()[1]);

        return sb.toString();
    }
}
