package heap;

public class MinHeap {

    public static void main(String[] args) {
        MinHeap head = new MinHeap(20);
        MinHeap minHeap = new MinHeap(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
       // minHeap.minHeap();

        minHeap.display();

        System.out.println("The Min val is " + minHeap.removeMin());

        minHeap.display();

        System.out.println("The Min val is " + minHeap.removeMin());
        minHeap.display();


    }

    private int[] head = null;
    private int maxSize ;
    private int size;

    public MinHeap(int maxSize) {
        maxSize = maxSize;
        size = 0;
        head = new int[maxSize + 1];
        head[0] = Integer.MIN_VALUE;
    }

    private int parentIndex(int index) {
        return index / 2;
    }

    private int leftIndex(int index) {
        return index * 2;
    }

    private int rightIndex(int index) {
        return index * 2 + 1;
    }

    private void minHeapify(int pos) {
        if (!isLeaf(pos)) {
            if (head[pos] > head[leftIndex(pos)] || head[pos] > head[rightIndex(pos)]) {

                if (head[leftIndex(pos)] < head[rightIndex(pos)]) {
                    swap(pos, leftIndex(pos));
                    minHeapify(leftIndex(pos));
                } else {
                    swap(pos, rightIndex(pos));
                    minHeapify(rightIndex(pos));
                }
            }
        }
    }

    private void swap(int i, int j) {
        int temp = head[i];
        head[i] = head[j];
        head[j] = temp;
    }

    public void insert(int obj) {
        head[++size] = obj;
        int current = size;

        while(head[current] < head[parentIndex(current)]) {
            swap(current, parentIndex(current));
            current = parentIndex(current);
        }
    }

    public int removeMin() {

        if(size <= 0) return Integer.MAX_VALUE;

        int max = head[1];

        swap(1, size);

        minHeapify(1);

        size--;

        return max;
    }

    public void minHeap() {
        for(int i = size / 2; i >=0; i--) {
            minHeapify(i);
        }
    }

    public boolean isLeaf(int pos) {
        if (pos >= size /2 && pos <= size)
            return true;
        return false;
    }

    public void display() {
        for (int i = 1; i <= size / 2; i++ )
        {
            System.out.print(" PARENT : " + head[i] + " LEFT CHILD : " + head[2*i]
                    + " RIGHT CHILD :" + head[2 * i  + 1]);
            System.out.println();
        }
    }
}
