package top100;

/**
 * https://leetcode.com/problems/jump-game-ii/discuss/18014/Concise-O(n)-one-loop-JAVA-solution-based-on-Greedy
 */
public class JumpGameII {

    public int jump(int[] nums) {
        int jumps = 0, curEnd = 0, farestEnd = 0;  

        for(int i = 0; i < nums.length - 1; i++) {


            farestEnd = Math.max(farestEnd, i + nums[i]);

            // 每次找一个范围内，能够到达的最远位置，到达结束点后，算一次跳跃。开始下一轮
            if (i == curEnd) {
                jumps++;
                curEnd = farestEnd;

                if (curEnd >= nums.length - 1) {
                    break;
                }
            }

        }

        return jumps;
    }
}
