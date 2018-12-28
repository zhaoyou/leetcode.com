package String;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

    @Test
    public void test() {
        String[] emails = {"test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};

        System.out.println(numUniqueEmails(emails));
    }

    public int numUniqueEmails(String[] emails) {

        Set<String> set = new HashSet<>();

        for(String email: emails) {
            String[] source = email.split("@");

            String[] prev = source[0].split("\\+");

            String localName = prev[0].replaceAll("\\.", "");

            //System.out.println(localName + "@" + source[1]);

            set.add(localName + "@" + source[1]);
        }

        return set.size();
    }
}
