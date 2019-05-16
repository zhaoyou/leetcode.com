package DP;

import org.junit.Test;

import java.util.Arrays;

public class BoatsToSavePeople {

    @Test
    public void test() {
       int[] people = {3,5,3,4};
       int limit = 5;

        System.out.println(numRescueBoats(people, limit));
    }

    /**
     * The i-th person has weight people[i], and each boat can carry a maximum weight of limit.
     *
     * Each boat carries at most 2 people at the same time, provided the sum of the weight of those people is at most limit.
     *
     * Return the minimum number of boats to carry every given person.  (It is guaranteed each person can be carried by a boat.)
     *
     *
     *
     * Example 1:
     *
     * Input: people = [1,2], limit = 3
     * Output: 1
     * Explanation: 1 boat (1, 2)
     * Example 2:
     *
     * Input: people = [3,2,2,1], limit = 3
     * Output: 3
     * Explanation: 3 boats (1, 2), (2) and (3)
     * Example 3:
     *
     * Input: people = [3,5,3,4], limit = 5
     * Output: 4
     * Explanation: 4 boats (3), (3), (4), (5)
     * Note:
     *
     * 1 <= people.length <= 50000
     * 1 <= people[i] <= limit <= 30000
     * @param people
     * @param limit
     * @return
     */
    public int numRescueBoats(int[] people, int limit) {
        int len = people.length;
        int left = 0, right = len - 1;

        Arrays.sort(people);

        int res = 0;

        while(left <= right) {
            if (people[left] + people[right] <= limit) left++;
            right--;
            res++;
        }

        return res;
    }
}
