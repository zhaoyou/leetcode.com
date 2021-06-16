package top100;

public class TaskScheduler {
    /**
     * https://leetcode.com/problems/task-scheduler/discuss/104500/Java-O(n)-time-O(1)-space-1-pass-no-sorting-solution-with-detailed-explanation
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        int max = 0;
        int maxCount = 0;

        for(char task: tasks) {
            counter[task - 'A']++;

            if (max == counter[task - 'A']) {
                maxCount++;
            } else if (max < counter[task - 'A']) {
                max = counter[task - 'A'];
                maxCount = 1;
            }
        }


        int partCount = max - 1;
        int partLen = n - (maxCount - 1);

        int space = partCount * partLen;

        int needTask = tasks.length - (max * maxCount);

        int idle = Math.max(0, space - needTask);

        return tasks.length + idle;
    }
}
