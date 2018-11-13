package String;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * reference: https://blog.csdn.net/liangzhaoyang1/article/details/51415719 (深度优先搜索 depth first search DFS)
 * https://www.cnblogs.com/springfor/p/3886409.html
 */
public class RestoreIPAddresses {


    @Test
    public void test() {
        String s = "1222212342";
        System.out.println(restoreIpAddresses(s));
    }

    public List<String> restoreIpAddresses(String s) {

        List<String> list = new ArrayList<>();

        if (s == null || s.length() < 4 || s.length() > 12) return list;


        dfs(s, 0, "", list);
        return list;
    }

    public void dfs(String s, int start, String item, List<String> list) {

        if (start == 3 && isValidNumber(s)) {
            list.add(item + s);
            return;
        }

        for(int i = 0; i < 3 && i < s.length() - 1; i++) {
            String subStr = s.substring(0, i + 1);

            if (isValidNumber(subStr)) {
                dfs(s.substring(i + 1), start + 1, item + subStr + ".", list);
            }
        }

        return;
    }

    private boolean isValidNumber(String s) {
        if (s.charAt(0) == '0')
            return s.equals("0");

        int num = Integer.parseInt(s);

        if (num < 0 || num > 255) return false;

        return true;
    }

}
