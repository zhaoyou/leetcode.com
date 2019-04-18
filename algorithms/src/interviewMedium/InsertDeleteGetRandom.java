package interviewMedium;

import org.junit.Test;

import java.util.*;

public class InsertDeleteGetRandom {
    @Test
    public void test() {
        Integer[] arr = {1, 2, 3};

        Set<Integer> set = new HashSet<>();

        Map<Integer, Integer> map = new HashMap<>();

    }
}

class RandomizedSet {

    Set<Integer> set = new HashSet<>();

    Map<Integer, Integer> map = new HashMap<>();

    List<Integer> list = new ArrayList<>();

    int i = 0;


    /** Initialize your data structure here. */
    public RandomizedSet() {

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean flag = set.add(val);
        if (flag) {
            map.put(i++, val);
        }


        return flag;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean flag = set.remove(val);

        return flag;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return 0;
    }
}