import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class PriorityQueueExample {

    public static void main(String[] args) {
        Queue<Integer> integerQueue = new PriorityQueue<>();

        Random random = new Random();

        for(int i = 0; i < 7; i++) {
            integerQueue.add(random.nextInt(100));
        }

        for(int i = 0; i < 7; i++) {
            int v = integerQueue.poll();
            System.out.println("Processing Integer: " + v);
        }

        Queue<Customer> customerQueue = new PriorityQueue<>(idComparator);

        addDataToQueue(customerQueue);
        pollDataFromQueue(customerQueue);
    }

    public static Comparator<Customer> idComparator = new Comparator<Customer>() {
        @Override
        public int compare(Customer o1, Customer o2) {
            return o1.getId() - o2.getId();
        }
    };

    //用于往队列增加数据的通用方法
    private static void addDataToQueue(Queue<Customer> customerPriorityQueue) {
        Random rand = new Random();
        for(int i=0; i<7; i++){
            int id = rand.nextInt(100);
            customerPriorityQueue.add(new Customer(id, "Pankaj "+id));
        }
    }

    //用于从队列取数据的通用方法
    private static void pollDataFromQueue(Queue<Customer> customerPriorityQueue) {
        while(true){
            Customer cust = customerPriorityQueue.poll();
            if(cust == null) break;
            System.out.println("Processing Customer with ID="+cust.getId());
        }
    }
}

class Customer {

    private int id;
    private String name;

    public Customer(int i, String n){
        this.id=i;
        this.name=n;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
