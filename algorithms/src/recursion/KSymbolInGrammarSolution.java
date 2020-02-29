package recursion;

import org.junit.Test;

public class KSymbolInGrammarSolution {
    public int kthGrammar(int N, int K) {

        if (N == 1) return 0;
        if (N == 2) return (K == 2) ? 1 : 0;

        int result = kthGrammar(N -1 , (K + 1) / 2);

        if (result == 0) {
            return K % 2 == 0 ? 1 : 0;
        } else {
            return K % 2 == 0 ? 0 : 1;
        }
    }

    @Test
    public void test() {
        int N = 4;
        int K = 5;
        System.out.println(kthGrammar(1 , 1));
        System.out.println(kthGrammar(2 , 1));
        System.out.println(kthGrammar(2 , 2));
        System.out.println(kthGrammar(4, 5));


    }
}
