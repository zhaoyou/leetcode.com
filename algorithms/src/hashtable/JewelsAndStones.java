package hashtable;

import org.junit.Test;

import java.util.HashMap;

public class JewelsAndStones {

    @Test
    public void test() {
        String J = "aA", S = "aAAbbbb";
        System.out.println(numJewelsInStones(J, S));
    }

    public int numJewelsInStones(String J, String S) {
        HashMap<Character, Character> map = new HashMap<>();
        for(char c: J.toCharArray()) map.put(c, c);
        int res = 0;
        for(char c: S.toCharArray()) if (map.containsKey(c)) res++;
        return res;
    }
}
