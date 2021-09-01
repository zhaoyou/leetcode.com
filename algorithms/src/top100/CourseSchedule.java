import java.util.LinkedList;
import java.util.Queue;

/**
 * https://zhuanlan.zhihu.com/p/135094687
 */
public class CourseSchedule {   
    
/**
 * 2
    [[1,0]]
 * @param numCourses
 * @param prerequisites
 * @return
 */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] indegree = new int[numCourses];
        int[] res = new int[numCourses];

        // 计算每个课程的入度数量
        for(int[] pre: prerequisites) {
            indegree[pre[0]] = indegree[pre[0]] + 1;
        }

        Queue<Integer> queue = new LinkedList<>();

        // 把入度数是0 的加入到队列去计算
        for(int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        int i = 0; 

        while(!queue.isEmpty()) {


            int cur = queue.poll(); // 从队列拿出入度为0的节点处理

            res[i++] = cur;

            // 正边操作
            for(int[] edge: prerequisites) {

                if (edge[1] == cur) { // 找到以当前顶点出度的边，清除
                    indegree[edge[0]]--;

                    if (indegree[edge[0]] == 0) 
                        queue.offer(edge[0]);
                }
            }

        }

        return i == numCourses; 
        
    }
    
}
