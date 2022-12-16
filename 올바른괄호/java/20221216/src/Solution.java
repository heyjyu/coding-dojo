import java.util.*;
import java.util.stream.*;

class Solution {
    void test() {
        System.out.println("correctParentheses(\"()()\"): true = " + correctParentheses("()()"));
    }

    boolean solution(String s) {
//        test();
        boolean answer = correctParentheses(s);

        return answer;
    }

    boolean correctParentheses(String string) {
        List<String> stack = new ArrayList<>();

        for (int i = 0; i < string.length(); i += 1) {
            if (string.charAt(i) == '(') {
                stack.add(string.substring(i, i + 1));

                continue;
            }

            if (stack.size() == 0) {
                return false;
            }

            stack.remove(stack.size() - 1);
        }

        if (stack.size() == 0) {
            return true;
        }

        return false;
    }
}
