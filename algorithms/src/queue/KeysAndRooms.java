package queue;

import org.junit.Test;

import java.util.*;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms.size() == 1) return true;

        Queue<Integer> queue = new LinkedList<>();

        Set<Integer> set = new HashSet<>();

        queue.add(0);

        set.add(0);


        while(!queue.isEmpty()) {

            int key = queue.poll();
            for(Integer k: rooms.get(key)) {
                if (!set.contains(k)) {
                    queue.add(k);
                    set.add(k);
                }
            }
        }
        return rooms.size() == set.size();
    }



    @Test
    public void test() {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 3));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(3, 0, 1));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(2));
        List<Integer> list4 = new ArrayList<>(Arrays.asList(0));


        List<List<Integer>> rooms = new ArrayList<>(Arrays.asList(list1, list2, list3, list4));

        System.out.println(canVisitAllRooms(rooms));
    }
}
