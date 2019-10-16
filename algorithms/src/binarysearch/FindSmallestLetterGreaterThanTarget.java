package binarysearch;

import org.junit.Assert;
import org.junit.Test;

public class FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {

        int right = letters.length;
        int start = 0;

        while(start < right) {

            int mid = start + (right - start) / 2;

            if (letters[mid] <= target) {
                start = mid + 1;
            } else {
                right = mid;
            }
        }

        if (right >= letters.length) {
            if (letters[right - 1] <= target) {
                right = 0;
            } else {
                right -=1;
            }
        }

        return letters[right];
    }

    @Test
    public void test() {
        char[] letters = new char[] {'c','f','j'};
        char target = new Character('k');

        Assert.assertEquals(nextGreatestLetter(letters, 'a'), 'c');
        Assert.assertEquals(nextGreatestLetter(letters, 'c'), 'f');
        Assert.assertEquals(nextGreatestLetter(letters, 'f'), 'j');
        Assert.assertEquals(nextGreatestLetter(letters, 'g'), 'j');
        Assert.assertEquals(nextGreatestLetter(letters, 'j'), 'c');
        Assert.assertEquals(nextGreatestLetter(letters, 'z'), 'c');
    }

}
