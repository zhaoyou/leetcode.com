package interviewMedium.backtracking;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EightQueensPuzzle {

    int size = 8;


    @Test
    public void test() {
        List<Integer> list = new ArrayList<>();
        int [] arr = new int[size];
        eightQueen(arr, 0);
    }


    public void eightQueen(int[] arr, int row) {


        if (row  ==  size) {
            System.out.println(Arrays.toString(arr));
            return;
        }

        for(int i = 0; i < size; i++) {
            arr[row] = i;
            if (isValid(arr, row)) {
                //System.out.println("isValid");
                eightQueen(arr, row + 1);
            }
        }

    }

    private boolean isValid(int[] arr, int row) {



        for(int i = 0; i < row; i++) {

            int oldCol = arr[i];

            if (oldCol == arr[row]) return false;    // 排除同一列

            if (Math.abs(row - i) == Math.abs(arr[row] - oldCol)) return false; // 排除对角线

        }
        return true;
    }

}
