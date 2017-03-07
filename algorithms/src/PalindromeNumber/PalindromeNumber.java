package PalindromeNumber;

/**
 * Created by zhaoyou on 07/03/2017.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) { return false;}

        int y = 1;

        while(x/y >=10) {   // 计算数字的位数
            y *= 10;
        }

        while(x != 0) {
            if (x/y != x%10) return false;  // 如果最高位和最低位不相同,怎肯定不是回文数,直接返回
            x = (x % y) / 10; // %y 是缩短高位  /10 是去掉低位
            y /= 100;         // 位数相应的就应该见两位
        }
        return true;
    }
}
