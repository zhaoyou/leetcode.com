package twopoint;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        Map<Character, Integer> indexMap = new HashMap<>();

        int[] map = new int[26];

        char[] arr = S.toCharArray();
        List<Integer> list = new LinkedList<>();

        // 记录每一个字符最后的位置
        for(int i = 0; i < arr.length; i++) { map[arr[i] - 'a'] = i; }

        int start = 0, end = 0;

        for(int j = 0; j < arr.length; j++) {

            end = Math.max(end, map[arr[j] - 'a']);

            if (end == j) {
                list.add(end - start + 1);
                start = j + 1;
                end = 0;
            }


        }

        return list;
    }

    @Test
    public void test() {
        String S = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(S));
    }
}
