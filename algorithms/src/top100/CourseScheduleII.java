package top100;

import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        int[] res = new int[numCourses];

        Queue<Integer> queue = new LinkedList<>();

  

        // 统计每个顶点的入度数
        for(int[] pre: prerequisites) {
            degree[pre[0]] ++;
        }

        // 没有入度的点加入队列
        for(int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) queue.offer(i);
        }

        int i = 0; 

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            res[i++] = cur;

            for(int[] pre: prerequisites) {
                if (pre[1] == cur) {
                    degree[pre[0]]--;

                    if (degree[pre[0]] == 0) {
                        queue.offer(pre[0]);
                    }
                }
            }
        }

        return res;

    }
    
}
