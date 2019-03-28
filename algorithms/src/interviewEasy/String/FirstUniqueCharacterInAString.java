package interviewEasy.String;

public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int[] dp = new int[26];

        for(char c: s.toCharArray()) {
            dp[c - 'a']++;
        }

        for(int i = 0; i < s.length(); i++) {
            if (dp[s.charAt(i) - 'a'] == 1) return i;
        }

        return -1;
    }
}
