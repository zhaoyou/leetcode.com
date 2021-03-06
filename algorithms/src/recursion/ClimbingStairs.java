package recursion;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int[] arr = new int[n + 1];

        arr[1] = 1;
        arr[2] = 2;

        for(int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    public static void main(String[] args) {
        System.out.println("MIN_VALUE: " + Integer.MIN_VALUE);
        System.out.println("MAX_VALUE: " + Integer.MAX_VALUE);
        int i = Integer.MIN_VALUE;
        System.out.println(0 - i);
    }
}
