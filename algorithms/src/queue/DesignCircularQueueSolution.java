package queue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/design-circular-queue/discuss/149420/Concise-Java-using-array
 */
public class DesignCircularQueueSolution {
    @Test
    public void test() {
        /**
         * Your MyCircularQueue object will be instantiated and called as such:
         * MyCircularQueue obj = new MyCircularQueue(k);
         * boolean param_1 = obj.enQueue(value);
         * boolean param_2 = obj.deQueue();2
         * int param_3 = obj.Front();
         * int param_4 = obj.Rear();
         * boolean param_5 = obj.isEmpty();
         * boolean param_6 = obj.isFull();
         */

        MyCircularQueue circularQueue = new MyCircularQueue(3); // set the size to be 3
        System.out.println(circularQueue.enQueue(1));  // return true
        System.out.println(circularQueue.enQueue(2));  // return true
        System.out.println(circularQueue.enQueue(3));  // return true
        System.out.println(circularQueue.enQueue(4));  // return false, the queue is full
        System.out.println(circularQueue.Rear());  // return 3
        System.out.println(circularQueue.isFull());  // return true
        System.out.println(circularQueue.deQueue());  // return true
        System.out.println(circularQueue.enQueue(4));  // return true
        System.out.println(circularQueue.Rear());  // return 4
    }
}

class MyCircularQueue {


    int head, tail = -1, len = 0;

    int[] arr;


    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        arr = new int[k];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {

        if (isFull()) {
            return false;
        } else {
            tail = (tail + 1) % arr.length;
            arr[tail] = value;
            len++;
            return true;
        }

    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        } else {
            head = (head + 1) % arr.length;
            len--;
            return true;
        }
    }

    /** Get the front item from the queue. */
    public int Front() {
        return isEmpty() ? -1 : arr[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        return isEmpty() ? -1 : arr[tail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return len == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return len == arr.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();2
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
