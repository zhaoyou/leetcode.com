package top100;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>(){

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            } 
        });

        
        List<int[]> list = new LinkedList();

        int[] prev = new int[2];

        prev = intervals[0];

        int len = intervals.length;

        for (int i = 1; i < len; i++) {

            if (prev[0] == intervals[i][0]) {
                prev[1] = Math.max(prev[1], intervals[i][1]);
            } else if (prev[0] <= intervals[i][0] && prev[1] >= intervals[i][0]) {
                prev[1] = Math.max(prev[1], intervals[i][1]);
            } else {
                list.add(prev);

                prev = intervals[i];
            }
        }


        list.add(prev);


        return list.toArray(new int[2][list.size()]);


    }

    public int[][] merge2(int[][] intervals) {
        if (intervals.length <= 1) return intervals;


        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> list = new LinkedList<>();

        int[] result = new int[2];

        result = intervals[0];

        list.add(result);


        for(int[] interval: intervals) {

        }

        return list.toArray(new int[list.size()][2]);
    }
}
