package binarysearchtree;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAStream {

}

/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/discuss/149050/Java-Priority-Queue
 */
class KthLargest {

    int k = 0;
    Queue<Integer> queue = null;

    public KthLargest(int k, int[] nums) {
        this.queue = new PriorityQueue<>(k);
        this.k = k;
        for(int num: nums) add(num);
    }

    public int add(int val) {

        queue.offer(val);

        if (queue.size() > k) queue.poll();

        return queue.peek();
    }
}

