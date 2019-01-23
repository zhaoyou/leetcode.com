package manipulation;

import org.junit.Test;

/**
 * reference:
 * https://blog.csdn.net/dianxin113/article/details/71713644
 */
public class PoorPigs {

    @Test
    public void test() {
        System.out.println(poorPigs(3, 15, 60));
    }


    /**
     * 本题可以这么考虑问题, 先是二维地排列罐子, 然后分别让两头猪去尝试找出哪一行和哪一列有毒.间隔时间为15分钟, 由于测试时间是60分钟 所以总共1只猪能测试5行或者5列. (这里不是4行或者4列, 因为如果前面4个测试猪都没死的话, 说明最后一行/最后一列肯定有毒). 总结一下,1个维度交给1只猪,  能帮我们检查出(测试时间/毒发时间 + 1)个维度单位.
     *
     * 那么回到二维的例子里面, 2只猪能帮我们检查5*5=25个罐子,那么如果是三维, 就是5^3 = 125个, 以此类推随着维度的上升,只要最后的水桶数大于我们需要检查的水桶数,就需要几头猪.
     *
     *
     * ---------------------
     * @param buckets
     * @param minutesToDie
     * @param minutesToTest
     * @return
     */
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int testCounts = (minutesToTest / minutesToDie)  + 1;
        int pigs = 0;
        while(Math.pow(testCounts, pigs) < buckets) { pigs++;}
        return pigs;
    }


    /**
     * 使用bit操作。Fail
     * @param buckets
     * @param minutesToDie
     * @param minutesToTest
     * @return
     */
    public int poorPigs2(int buckets, int minutesToDie, int minutesToTest) {
        if (buckets == 1) return 0;
        int testCounts = (minutesToTest / minutesToDie)  + 1;
        int i = (int)(Math.log(buckets - 1) / Math.log(2)) + 1;
        System.out.println("testCounts: " + testCounts + " i" + i);
        return i <= testCounts ? i : i - testCounts;
    }


}
