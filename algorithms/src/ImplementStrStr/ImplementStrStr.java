package ImplementStrStr;

public class ImplementStrStr {

    public static void main(String[] args) {
        System.out.println(new ImplementStrStr().strStr("aaaaa", "bba"));
    }

    public int strStr(String haystack, String needle) {

        if (needle.isEmpty()) return 0;

        int start ;

        for (int i = 0; i < haystack.length(); i++) {

            char cur = haystack.charAt(i);

            start = i;

            int index = 0;

            while(index < needle.length() &&
                    needle.charAt(index) == cur) {

                index ++;
                start++;

                if (start < haystack.length()) {
                    cur = haystack.charAt(start);
                } else {
                    // 主字符串已经遍历结束，子字符串如果还没有结束，则代表没有找到。
                    if (index != needle.length()) return -1;
                }
            }

            if (index == needle.length())  {
                return start - needle.length() ;
            }
        }
        return -1;
    }


}