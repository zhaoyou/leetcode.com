package String;

import org.junit.Test;

import java.util.Stack;

/**
 * reference: http://www.cnblogs.com/grandyang/p/4606676.html
 */
public class ReverseWordsInAString {

    @Test
    public void test() {
        String input = " the sky is   blue ";
        System.out.println(reverseWords(input));
    }

    public String reverseWords(String s) {

        if (s == null || "".equals(s.trim())) return "";

        s = s.trim();
        Stack<String> stack = new Stack<>();

        StringBuffer item = new StringBuffer("");
        int len = s.length();
        for(int i = 0; i < len; i++) {

            if (s.charAt(i) == ' ' && ! "".equals(item.toString())) {
               stack.push(item.toString());
               item = new StringBuffer("");
            } else if (s.charAt(i) != ' ') {
                item.append(s.charAt(i));
            }
        }

        if (item.toString() != "") stack.push(item.toString());

        item = new StringBuffer("");
        while(!stack.empty()) item.append(stack.pop() + " ");


        return item.toString().trim();
    }


    public String reverseWords2(String s) {
        String res = "";
        String[] words = s.trim().split("\\s+");
        for (int i = words.length - 1; i > 0; --i) {
            res += words[i] + " ";
        }
        return res + words[0];
    }

}
