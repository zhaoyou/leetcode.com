package String;

import org.junit.Test;

public class RobotReturnToOrigin {

    @Test
    public void test() {
        String moves = "UDLRDURLU";
        System.out.println(moves + " judgeCircle: " + judgeCircle(moves));
    }


    public boolean judgeCircle(String moves) {
        int row = 0, col = 0;
        for(char c : moves.toCharArray()) {
            switch (c) {
                case 'U': row--;break;
                case 'D': row++;break;
                case 'L': col--;break;
                case 'R': col++;break;
            }
        }
        return row == 0 && col == 0;
    }
}
