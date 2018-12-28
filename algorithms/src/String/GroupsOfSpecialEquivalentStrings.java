package String;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * reference:
 * https://zhanghuimeng.github.io/post/leetcode-893-groups-of-special-equivalent-strings/
 */
public class GroupsOfSpecialEquivalentStrings {

    @Test
    public void test() {
        String[] A = {"abcd","cdab","adcb","cbad"};
        System.out.println(numSpecialEquivGroups(A));
    }

    public int numSpecialEquivGroups(String[] A) {


        Set<String> set = new HashSet<>();

        for(String word: A) {

            StringBuffer sbOdd = new StringBuffer();
            StringBuffer sbEven = new StringBuffer();

            for(int i = 0; i < word.length(); i ++) {
                if (i % 2 == 0) sbEven.append(word.charAt(i));
                else sbOdd.append(word.charAt(i));
            }

            char[] oddArr = sbOdd.toString().toCharArray();
            char[] evenArr = sbEven.toString().toCharArray();

            Arrays.sort(oddArr);
            Arrays.sort(evenArr);

            set.add(new String(oddArr) + new String(evenArr));
        }

        return set.size();
    }
}
