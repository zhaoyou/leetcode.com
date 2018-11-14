package String;

public class ReverseString {

    public String reverseString(String s) {

        if (s == null || "".equals(s)) return s;

        char[] arr = s.toCharArray();

        int i = 0, end = arr.length - 1;

        while(i < end) {
            char temp = arr[i];
            arr[i] = arr[end];
            arr[end] = temp;

            i++;
            end--;
        }

        return new String(arr);
    }
}
