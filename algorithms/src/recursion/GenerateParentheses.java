package recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrace(list, new char[n * 2], 0);
        return list;
    }

    private void backtrace(List<String> result, char[] sb,  int index) {

        if (index == sb.length){
            if (isValid(sb)) {
                result.add(new String(sb));
                return;
            }
        } else {
            sb[index] = '(';
            backtrace(result, sb, index + 1);
            sb[index] = ')';
            backtrace(result, sb, index + 1);

        }

    }

    private boolean isValid(char[] sb) {
        int i = 0, k = 0;

        for(char c: sb) {
            if (i < 0 ) return false;
            if (c == '(') i++;
            else i--;
        }

        return i == 0;

    }


    public List<String> generateParenthesis2(int n) {
        List<String> list = new ArrayList<>();
        helper(list, 0, 0, n , "");
        return list;
    }

    private void helper(List<String> list, int left, int right, int n, String cur) {
        if (left == n && right == n){
            list.add(cur);
            return;
        }


        if (left < n)
            helper(list, left + 1, right, n, cur + "(");

        if (right < left)
            helper(list, left, right + 1, n, cur + ")");
    }

    public List<String> generateParenthesis3(int n) {
        List<String> list = new ArrayList<>();
        helper3(list, n, 0, n , "");
        return list;
    }

    private void helper3(List<String> list, int left, int right, int n, String cur) {
        if (left == 0 && right == 0){
            list.add(cur);
            return;
        }

        if (left > 0)
            helper3(list, left - 1, right + 1, n, cur + "(");

        if (right > 0)
            helper3(list, left, right - 1, n, cur + ")");
    }

    @Test
    public void test() {
        int n = 10;
        Long s = System.currentTimeMillis();
        System.out.println(generateParenthesis(n));
        System.out.println("cost: " + (System.currentTimeMillis() - s));
        s = System.currentTimeMillis();
        System.out.println(generateParenthesis2(n));
        System.out.println("cost: " + (System.currentTimeMillis() - s));
        s = System.currentTimeMillis();
        System.out.println(generateParenthesis3(n));
        System.out.println("cost: " + (System.currentTimeMillis() - s));

    }
}
