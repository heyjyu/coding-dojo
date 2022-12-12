import java.util.*;
import java.util.stream.*;

class Solution {
    public void test() {
        System.out.println("getMaximum(\"1 2 3 4\"): 4 = " + getMaximum("1 2 3 4"));
        System.out.println("getMaximum(\"-1 -2 -3 -4\"): -1 = " + getMaximum("-1 -2 -3 -4"));
        System.out.println("getMaximum(\"-1 -1\"): -1 = " + getMaximum("-1 -1"));

        System.out.println("getMinimum(\"1 2 3 4\"): 1 = " + getMinimum("1 2 3 4"));
        System.out.println("getMinimum(\"-1 -2 -3 -4\"): -4 = " + getMinimum("-1 -2 -3 -4"));
        System.out.println("getMinimum(\"-1 -1\"): -1 = " + getMinimum("-1 -1"));
        
        System.out.println("getMinimumAndMaximum(\"1 2 3 4\"): 1 4 = " + getMinimumAndMaximum("1 2 3 4"));
    }

    public String solution(String s) {
        // test();
        String answer = getMinimumAndMaximum(s);
        return answer;
    }

    public Integer getMaximum(String string) {
        return Arrays.stream(string.split(" "))
                .mapToInt(i -> Integer.valueOf(i))
                .max()
                .getAsInt();
    }

    public Integer getMinimum(String string) {
        return Arrays.stream(string.split(" "))
                .mapToInt(i -> Integer.valueOf(i))
                .min()
                .getAsInt();
    }
    
    public String getMinimumAndMaximum(String string) {
        return getMinimum(string) + " " + getMaximum(string);
    }
}
