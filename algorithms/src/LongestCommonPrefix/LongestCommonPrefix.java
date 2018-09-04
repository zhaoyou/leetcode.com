package LongestCommonPrefix;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] source = {"flower","flow","flight"};
        String[] source2 = {"dog","racecar","car"};

        System.out.println(longestCommonPrefix3(source));
        System.out.println(longestCommonPrefix3(source2));

    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) { return "";}
        String result = strs[0];
        for(int i = 1; i < strs.length; i++) {
            int j = 0;
            String subStr = "";
            for( ;j < result.length() 
                            && j < strs[i].length(); j++) {
                
                if (result.charAt(j) == strs[i].charAt(j)) {
                    subStr = strs[i].substring(0, j + 1);
                    continue;
                } else {
                    if (j == 0) subStr = "";
                    break;
                }
            }
            result = subStr;
        }
        return result;
    }

    /**
     * 水平比较
     * @param strs
     * @return
     */
    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) {return "";}
        String result = strs[0];
        for(int i = 1; i < strs.length; i++) {
            while(strs[i].indexOf(result) != 0) {
                result = result.substring(0, result.length() - 1);
                if (result.isEmpty())
                    return "";
            }
        }
        return result;
    }

    /**
     * 垂直比较
     * @param strs
     * @return
     */
    public static String longestCommonPrefix3(String[] strs) {
        if (strs.length == 0) return "";
        String result = strs[0];
        for(int i = 0; i < result.length(); i++) {
            char c = result.charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (c != strs[j].charAt(i) || i == strs[j].length()) {
                    return result.substring(0, i);
                }
            }
        }
        return result;
    }
}