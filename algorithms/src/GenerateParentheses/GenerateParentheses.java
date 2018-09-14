package GenerateParentheses;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }


    public static List<String> generateParenthesis(int n) {
        LinkedList<String> result = new LinkedList<String>();
        if(n== 0)   return result;
        backtracing(result,0,0,"",n);
        return result;
    }
    static void  backtracing(LinkedList<String> result, int left, int right, String par, int max)
    {
        if(par.length() == 2*max)
        {
            result.add(par);
            return;
        }
        if(left < max) {
            System.out.println("left < max: ");
            backtracing(result, left + 1, right, par + '(', max);
        }
        if(right < left) {
            System.out.println("right < left: ");
            backtracing(result, left, right + 1, par + ')', max);
        }

        System.out.println("loop....");
    }

}
