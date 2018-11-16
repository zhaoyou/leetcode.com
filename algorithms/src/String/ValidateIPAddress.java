package String;

import org.junit.Test;

public class ValidateIPAddress {


    @Test
    public  void test() {
        String ip = "172.16.254.1";
        String ip2 = "2001:0db8:85a3:0:0:8A2E:0370:7334";
        String ip3 = "256.256.256.256";
        String ip4 = "a:a:a:a:a:a:a:a";

        System.out.println(ip + " is: " + validIPAddress(ip));
        System.out.println(ip2 + " is: " + validIPAddress(ip2));
        System.out.println(ip3 + " is: " + validIPAddress(ip3));
        System.out.println(ip4 + " is: " + validIPAddress(ip4));




    }

    public String validIPAddress(String IP) {

        if (IP == null || "".equals(IP)) return "Neither";

        if (isIP4(IP)) return "IPv4";
        if (isIP6(IP)) return "IPv6";
        return "Neither";
    }

    private boolean isIP4(String s) {
        if (!s.contains(".")) return false;
        if (s.charAt(0) == '.' || s.charAt(s.length() - 1) == '.') return false;

        String arr[] =  s.split("\\.");

        if (arr.length != 4) return false;

        for (String subStr: arr) {
            if (subStr == null || "".equals(subStr) || subStr.length() > 3) return false;
            if (subStr.charAt(0) == '0' && subStr.length() != 1) return false;
            if (!(subStr.charAt(0) >= '0' && subStr.charAt(0) <= '2')) return false;

            try {
                int num = Integer.parseInt(subStr);
                if (num < 0 || num > 255) return false;
            } catch (Exception e) {
                return false;
            }

        }
        return true;
    }

    private boolean isIP6(String s) {
        if (!s.contains(":")) return false;

        if (s.charAt(0) == ':' || s.charAt(s.length() - 1) == ':') return false;

        String arr[] = s.split(":");

        if (arr.length != 8) return false;
        for(String subStr: arr) {
            if (subStr == null || "".equals(subStr)) return false;

            if (subStr.length() > 4 ) return false;

            for(int i = 0; i < subStr.length(); i++) {
                char c = subStr.charAt(i);

                if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))) {
                  return false;
                }
            }
        }
        return true;
    }
}
