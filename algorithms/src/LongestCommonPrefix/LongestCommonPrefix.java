package LongestCommonPrefix;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] source = {"flower","flow","flight"};
        String[] source2 = {"dog","racecar","car"};

        System.out.println(longestCommonPrefix2(source));
        System.out.println(longestCommonPrefix2(source2));

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
}