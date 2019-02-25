package graph;

import org.junit.Test;

/**
 * reference:
 * https://leetcode.com/problems/find-the-town-judge/discuss/242938/JavaC++Python-Directed-Graph
 */
public class FindTheTownJudge {

    @Test
    public void test() {
        int[][] trust = {{1,3},{1,4},{2,3},{2,4},{4,3}};
        int N = 4;
        System.out.println(findJudge(N, trust));
    }


    public int findJudge(int N, int[][] trust) {
        int [] dp = new int[N + 1];
        for(int[] sub: trust) {
            dp[sub[0]]--;
            dp[sub[1]]++;
        }

        for(int i = 1; i <= N; i++) {
            if (dp[i] == N - 1) return i;
        }
        return -1;
    }
}
