package map;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {

        if (s.isEmpty() && t.isEmpty()) return true;

        int[] dp = new int[26];

        for(char c: s.toCharArray()) dp[c - 'a']++;
        for(char c: t.toCharArray()) dp[c - 'a']--;
        for(int i: dp) if (i != 0) return false;
        return true;
    }
}
