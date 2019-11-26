package binarysearch;

import org.junit.Test;

/**
 * reference:
 * CATF44LT7C-eyJsaWNlbnNlSWQiOiJDQVRGNDRMVDdDIiwibGljZW5zZWVOYW1lIjoiVmxhZGlzbGF2IEtvdmFsZW5rbyIsImFzc2lnbmVlTmFtZSI6IiIsImFzc2lnbmVlRW1haWwiOiIiLCJsaWNlbnNlUmVzdHJpY3Rpb24iOiJGb3IgZWR1Y2F0aW9uYWwgdXNlIG9ubHkiLCJjaGVja0NvbmN1cnJlbnRVc2UiOmZhbHNlLCJwcm9kdWN0cyI6W3siY29kZSI6IklJIiwicGFpZFVwVG8iOiIyMDIwLTAxLTA4In0seyJjb2RlIjoiQUMiLCJwYWlkVXBUbyI6IjIwMjAtMDEtMDgifSx7ImNvZGUiOiJEUE4iLCJwYWlkVXBUbyI6IjIwMjAtMDEtMDgifSx7ImNvZGUiOiJQUyIsInBhaWRVcFRvIjoiMjAyMC0wMS0wOCJ9LHsiY29kZSI6IkdPIiwicGFpZFVwVG8iOiIyMDIwLTAxLTA4In0seyJjb2RlIjoiRE0iLCJwYWlkVXBUbyI6IjIwMjAtMDEtMDgifSx7ImNvZGUiOiJDTCIsInBhaWRVcFRvIjoiMjAyMC0wMS0wOCJ9LHsiY29kZSI6IlJTMCIsInBhaWRVcFRvIjoiMjAyMC0wMS0wOCJ9LHsiY29kZSI6IlJDIiwicGFpZFVwVG8iOiIyMDIwLTAxLTA4In0seyJjb2RlIjoiUkQiLCJwYWlkVXBUbyI6IjIwMjAtMDEtMDgifSx7ImNvZGUiOiJQQyIsInBhaWRVcFRvIjoiMjAyMC0wMS0wOCJ9LHsiY29kZSI6IlJNIiwicGFpZFVwVG8iOiIyMDIwLTAxLTA4In0seyJjb2RlIjoiV1MiLCJwYWlkVXBUbyI6IjIwMjAtMDEtMDgifSx7ImNvZGUiOiJEQiIsInBhaWRVcFRvIjoiMjAyMC0wMS0wOCJ9LHsiY29kZSI6IkRDIiwicGFpZFVwVG8iOiIyMDIwLTAxLTA4In0seyJjb2RlIjoiUlNVIiwicGFpZFVwVG8iOiIyMDIwLTAxLTA4In1dLCJoYXNoIjoiMTE1MzA4ODUvMCIsImdyYWNlUGVyaW9kRGF5cyI6MCwiYXV0b1Byb2xvbmdhdGVkIjpmYWxzZSwiaXNBdXRvUHJvbG9uZ2F0ZWQiOmZhbHNlfQ==-BZLL+H88k449OQC56NsqU0fwb6wMAX1Di+CK5HS46DuOD1E68HPiTqREdn8DzrLVAoMkJReaH30RaIDLwUI8GEFifDcCYE5RbpE5ApNJ8mcUJr8oA1nrjY9IzZCgrSBFr4GAOLqSfXH+1UJ3K8UPqGh8nThomnKW9Jvv9pA7HIH/KrNm2RLV/aNMHWO8Q44A8ToXm7g5FS2lW903URPQ0KFgxT11w/KL81UkHm6yUXC7/LTAygIBArI8j+XUk3rlz4rpi2wrJclYXukrKQqH/V6CTbnVV3d6XAdtCqjryQ2Ga7bP/XTLjwAGwPEB3Q1W7LHNQ7CsyvZG/oTSOgD2YQ==-MIIElTCCAn2gAwIBAgIBCTANBgkqhkiG9w0BAQsFADAYMRYwFAYDVQQDDA1KZXRQcm9maWxlIENBMB4XDTE4MTEwMTEyMjk0NloXDTIwMTEwMjEyMjk0NlowaDELMAkGA1UEBhMCQ1oxDjAMBgNVBAgMBU51c2xlMQ8wDQYDVQQHDAZQcmFndWUxGTAXBgNVBAoMEEpldEJyYWlucyBzLnIuby4xHTAbBgNVBAMMFHByb2QzeS1mcm9tLTIwMTgxMTAxMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxcQkq+zdxlR2mmRYBPzGbUNdMN6OaXiXzxIWtMEkrJMO/5oUfQJbLLuMSMK0QHFmaI37WShyxZcfRCidwXjot4zmNBKnlyHodDij/78TmVqFl8nOeD5+07B8VEaIu7c3E1N+e1doC6wht4I4+IEmtsPAdoaj5WCQVQbrI8KeT8M9VcBIWX7fD0fhexfg3ZRt0xqwMcXGNp3DdJHiO0rCdU+Itv7EmtnSVq9jBG1usMSFvMowR25mju2JcPFp1+I4ZI+FqgR8gyG8oiNDyNEoAbsR3lOpI7grUYSvkB/xVy/VoklPCK2h0f0GJxFjnye8NT1PAywoyl7RmiAVRE/EKwIDAQABo4GZMIGWMAkGA1UdEwQCMAAwHQYDVR0OBBYEFGEpG9oZGcfLMGNBkY7SgHiMGgTcMEgGA1UdIwRBMD+AFKOetkhnQhI2Qb1t4Lm0oFKLl/GzoRykGjAYMRYwFAYDVQQDDA1KZXRQcm9maWxlIENBggkA0myxg7KDeeEwEwYDVR0lBAwwCgYIKwYBBQUHAwEwCwYDVR0PBAQDAgWgMA0GCSqGSIb3DQEBCwUAA4ICAQAF8uc+YJOHHwOFcPzmbjcxNDuGoOUIP+2h1R75Lecswb7ru2LWWSUMtXVKQzChLNPn/72W0k+oI056tgiwuG7M49LXp4zQVlQnFmWU1wwGvVhq5R63Rpjx1zjGUhcXgayu7+9zMUW596Lbomsg8qVve6euqsrFicYkIIuUu4zYPndJwfe0YkS5nY72SHnNdbPhEnN8wcB2Kz+OIG0lih3yz5EqFhld03bGp222ZQCIghCTVL6QBNadGsiN/lWLl4JdR3lJkZzlpFdiHijoVRdWeSWqM4y0t23c92HXKrgppoSV18XMxrWVdoSM3nuMHwxGhFyde05OdDtLpCv+jlWf5REAHHA201pAU6bJSZINyHDUTB+Beo28rRXSwSh3OUIvYwKNVeoBY+KwOJ7WnuTCUq1meE6GkKc4D/cXmgpOyW/1SmBz3XjVIi/zprZ0zf3qH5mkphtg6ksjKgKjmx1cXfZAAX6wcDBNaCL+Ortep1Dh8xDUbqbBVNBL4jbiL3i3xsfNiyJgaZ5sX7i8tmStEpLbPwvHcByuf59qJhV/bZOl8KqJBETCDJcY6O2aqhTUy+9x93ThKs1GKrRPePrWPluud7ttlgtRveit/pcBrnQcXOl1rHq7ByB8CFAxNotRUYL9IF5n3wJOgkPojMy6jetQA5Ogc8Sm7RG6vg1yow==
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {

        if (num == 1) return true;

        long left = 0, end = num / 2;

        while (left <= end) {

            long mid = left + ((end - left) / 2);

            System.out.println("left: " + left + " mid: " + mid + " end: " + end);

            System.out.println((mid * mid * 1l) + ":" + ((mid * mid * 1l) > num));

            if ((mid * mid * 1l) == num) return true;

            if ( (mid * mid * 1l) > num) {
                end = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    @Test
    public void test() {
//        for(int i = 0; i < 1000000; i ++) {
//            if (isPerfectSquare(i)) System.out.println(i);
//        }

        System.out.println(isPerfectSquare(808201));
    }
}