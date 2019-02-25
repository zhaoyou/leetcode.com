package Array;

import org.junit.Test;

public class GasStation {

    @Test
    public void test() {
        int[] gas = {2,3,4};
        int[] cost = {3,4,3};

        System.out.println(canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, sum = 0, total = 0;
        for(int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];

            if (sum < 0) {
                start = i + 1;
                sum = 0;
            }
        }
        return total >= 0 ? start : -1;
    }
}
