package DP;

/**
 * reference:
 * http://www.cnblogs.com/grandyang/p/5666502.html
 */
public class GuessNumberHigherOrLower extends GuessGame {

    public int guessNumber(int n) {
        if (guess(n) == 0) return n;
        int start = 1, end = n;

        while(start < end) {
            int mid = start + (end -start) / 2;

            int result = guess(mid);
            if (result == 0) return mid;
            else if (result == 1) start = mid;
            else if (result == -1) end = mid;
        }
        return start;
    }
}

class GuessGame {
    public int guess(int num) {
        return 0;
    }
}
