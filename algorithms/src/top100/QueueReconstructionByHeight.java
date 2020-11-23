package top100;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionByHeight {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();

        list.add(0, 1);
        list.add(0, 2);
        list.add(1, 3);

        list.add(5, 4);

        System.out.println(list.toString());
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });


        List<int[]> list = new LinkedList<>();

        for(int[] p: people) {
            list.add(p[1], p);
        }

        return list.toArray(new int[list.size()][]);

    }
}
