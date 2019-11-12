package binarysearch;

import org.junit.Assert;
import org.junit.Test;

/**
 * reference
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/discuss/110005/Easy-Binary-Search-in-Java-O(log(n))-time
 */
public class FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {

        int right = letters.length;
        int start = 0;

        while(start < right) {

            int mid = start + (right - start) / 2;

            if (letters[mid] <= target) {  // 直到找到第一个最大的值
                start = mid + 1;
            } else {
                right = mid;
            }
        }

        // 直接考虑 start % letters.length   (终止条件是 start == right)
//        if (right >= letters.length) {
//            if (letters[right - 1] <= target) {
//                right = 0;
//            } else {
//                right -=1;
//            }
//        }

        return letters[start % letters.length]; // 考虑若没有找到合适的，则left到达letters.length 则直接采用 start % letters.length
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
