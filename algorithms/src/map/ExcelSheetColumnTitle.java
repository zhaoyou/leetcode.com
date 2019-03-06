package map;

import org.junit.Test;

import java.util.HashMap;

public class ExcelSheetColumnTitle {

    @Test
    public void test() {
        int n = 52;
        System.out.println(convertToTitle(n));
    }

    public String convertToTitle(int n) {
            return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + (n % 26));
    }
}
