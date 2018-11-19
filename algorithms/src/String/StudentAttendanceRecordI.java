package String;

import org.junit.Test;

/**
 * You are given a string representing an attendance record for a student. The record only contains the following three characters:
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
 *
 * You need to return whether the student could be rewarded according to his attendance record.
 *
 * Example 1:
 * Input: "PPALLP"
 * Output: True
 *
 * Example 2:
 * Input: "PPALLL"
 * Output: False
 */
public class StudentAttendanceRecordI {

    @Test
    public void test() {
        String s = "LALL";
        System.out.println(s + " -> " + checkRecord(s));
    }

    public boolean checkRecord(String s) {
        if (s == null || "".equals(s)) return true;
        int aCount = 0;
        int lCount = 0;
        for (char c: s.toCharArray()) {
            if (c == 'A' ) {
                if (aCount++ >= 1) return false;
                lCount = 0;
            } else if (c == 'L' && lCount++ >= 2) {
                return false;
            } else {
                lCount = 0;
            }
        }
        return true;
    }
}
