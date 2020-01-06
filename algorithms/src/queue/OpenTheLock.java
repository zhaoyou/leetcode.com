package queue;

import org.junit.Test;

import java.util.*;

public class OpenTheLock {
    public int openLock(String[] deadends, String target) {

        Set<String> deadendsSet = new HashSet<>();

        deadendsSet.addAll(Arrays.asList(deadends));

        Set<String> visited = new HashSet<>();

        Queue<String> q = new LinkedList<>();


        if (deadendsSet.contains(target)) return -1;

        q.offer("0000");

        int level = 0;


        while(!q.isEmpty()) {

            int size = q.size();

            while(size > 0) {

                String s = q.poll();
                size--;

                if (deadendsSet.contains(s)) { continue;}

                if (target.equals(s)) return level;


                for(int i = 0; i < 4; i++) {
                    char c  = s.charAt(i);

                    String s1 = s.substring(0, i) + ( c == '9' ? 0 : (c - '0') + 1) + s.substring(i+1, s.length());
                    String s2 = s.substring(0, i) + ( c == '0' ? 9 : (c - '0') - 1) + s.substring(i+1, s.length());

                    if (!visited.contains(s1) && !deadendsSet.contains(s1)) {
                        q.add(s1);
                        visited.add(s1);
                    }


                    if (!visited.contains(s2) && !deadendsSet.contains(s2)) {
                        q.add(s2);
                        visited.add(s2);
                    }
                }
            }
            level++;
        }

        return -1;
    }

    public static void main(String[] args) {

    }

    @Test
    public void test() {
        String[] arr = {"0201","0101","0102","1212","2002"};
        String target = "0202";

        System.out.println(openLock(arr, target));
    }
}
