package String;

import org.junit.Test;

import java.util.*;

/**
 * You have an array of logs.  Each log is a space delimited string of words.
 *
 * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
 *
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits.
 * We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.
 *
 * Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.
 *
 * Return the final order of the logs.
 *
 *
 *
 * Example 1:
 *
 * Input: ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
 * Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 *
 *
 * Note:
 *
 * 0 <= logs.length <= 100
 * 3 <= logs[i].length <= 100
 * logs[i] is guaranteed to have an identifier, and a word after the identifier.
 */
public class ReorderLogFiles {


    @Test
    public void test() {
        String[] logs = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
        System.out.println(String.join(", ", reorderLogFiles(logs)));
    }

    public String[] reorderLogFiles(String[] logs) {

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                int o1Index = o1.indexOf(' ');
                int o2Index = o2.indexOf(' ') ;

                char o1c = o1.charAt(o1Index + 1);
                char o2c = o2.charAt(o2Index + 1);

                if (o1c <= '9' ) {
                    if (o2c <= '9') return 0;
                    else return 1;
                }

                if (o2c <= '9') return -1;

                int compare = o1.substring(o1Index + 1).compareTo(o2.substring(o2Index + 1));

                if (compare == 0) {
                    return o1.substring(0, o1c).compareTo(o2.substring(0, o2c));
                }


                return compare;
            }
        };

        Arrays.sort(logs, comparator);
        return logs;
    }
}
