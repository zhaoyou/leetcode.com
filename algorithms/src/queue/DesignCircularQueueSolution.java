package queue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

    List<Integer> list = null;

    long head = -1;
    long tail = -1;

    int size ;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        list = new ArrayList<>(k);
        for(int i = 0; i < k; i++) list.add(-1);
        size = k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {

        if (head == -1) {          // queue is empty
            head = 0;
            tail = 0;
            list.set((int)tail, value);
        } else {

            if (tail - head == size - 1) { // is full
                return false;
            } else {
                tail++;
                list.set((int)(tail % size), value);

            }
        }


        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (head == -1) return false;

        if (head == tail) {
            head = -1;
            tail = -1;
        } else {
            head++;
        }

        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        return head == -1 ? -1 : list.get((int)(head % size));
    }

    /** Get the last item from the queue. */
    public int Rear() {
        return head == -1 ? -1 : list.get((int)(tail % size));
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return head == -1;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return tail - head == size - 1;
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
