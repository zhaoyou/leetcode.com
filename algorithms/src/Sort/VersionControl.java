package Sort;

public class VersionControl {

    boolean isBadVersion(int version) {
        return true;
    }
}

class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int i = 1;
        while(i < n) {
            int mid = i + (n-i)/2;

            if (!isBadVersion(mid)) {
                i = mid + 1;
            } else {
                n = mid;
            }
        }

        return n;
    }
}