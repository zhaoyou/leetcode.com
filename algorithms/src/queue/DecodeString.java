package queue;

import java.util.Stack;

public class DecodeString {

    /**
     * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
     * @param s
     * @return
     */
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();

        Stack<StringBuilder> strStack = new Stack<>();

        StringBuilder cur = new StringBuilder();

        int count = 0;

        for(Character c: s.toCharArray()) {

            if (Character.isDigit(c)) {
                count = count * 10  + (c - '0');
            } else if (c == '[') {
                countStack.push(count);
                strStack.push(cur);

                cur = new StringBuilder();

                count = 0;
            } else if (c == ']') {

                StringBuilder temp = cur;
                cur = strStack.pop();

                for(int i = countStack.pop(); i > 0; i--) cur.append(temp);

            } else {
                cur.append(c);
            }
        }
        return cur.toString();
    }
}
