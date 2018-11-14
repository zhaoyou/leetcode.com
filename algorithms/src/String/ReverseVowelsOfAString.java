package String;

public class ReverseVowelsOfAString {

    public String reverseVowels(String s) {
        if (s == null || "".equals(s)) return s;

        char[] arr = s.toCharArray();

        int i = 0, j = s.length() - 1;

        while(i < j) {
            if (!isVowel(arr[i])) i++;
            else if (!isVowel(arr[j])) j--;
            else {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        return new String(arr);
    }

    private boolean isVowel(char c) {
        if (c == 'a' || c == 'A') return true;
        if (c == 'e' || c == 'E') return true;
        if (c == 'i' || c == 'I') return true;
        if (c == 'o' || c == 'O') return true;
        if (c == 'u' || c == 'U') return true;
        return false;
    }
}
