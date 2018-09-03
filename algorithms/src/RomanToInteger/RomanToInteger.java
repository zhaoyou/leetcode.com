package RomanToInteger;

public class RomanToInteger {

    public static void main(String[] args) {
        String [] source = {"III", "IV", "IX", "LVIII", "MCMXCIV"};
        for(int j = 0; j < source.length; j++) {
            System.out.println(romanToInt(source[j]));
        }
    }

    public static int romanToInt(String s) {
        int result = 0;
        int i = 0;
        int len = s.length();
        while (i < len) {
            if (s.charAt(i) == 'M') {
                result += 1000;
                i++;
                continue;
            } else if (s.charAt(i) == 'D') {
                result += 500;
                i++;
                continue;
            } else if (s.charAt(i) == 'C') {

                if (i + 1 < len && s.charAt(i + 1) == 'D') {
                    result += 400;
                    i++;
                } else if (i + 1 < len && s.charAt(i + 1) == 'M') {
                    result += 900;
                    i++;
                } else {
                    result += 100;
                }
                i++;
                continue;
            } else if (s.charAt(i) == 'L') {
                result += 50;
                i++;
                continue;
            } else if (s.charAt(i) == 'X') {

                if (i + 1 < len && s.charAt(i + 1) == 'L') {
                    result += 40;
                    i++;
                } else if (i + 1 < len && s.charAt(i + 1) == 'C') {
                    result += 90;
                    i++;
                } else {
                    result += 10;
                }
                i++;
                continue;
            } else if (s.charAt(i) == 'V') {
                result += 5;
                i++;
                continue;
            } else if (s.charAt(i) == 'I') {

                if (i + 1 < len && s.charAt(i + 1) == 'V') {
                    result += 4;
                    i++;
                } else if  (i + 1 < len && s.charAt(i + 1) == 'X') {
                    result += 9;
                    i++;
                }else {
                    result += 1;
                }

                i++;
                continue;
            }
        }
        return result;
    }
}