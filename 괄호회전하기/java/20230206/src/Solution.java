import java.util.*;

class Solution {
    public void test() {
        System.out.println("rotate(0, \"[](){}\"): [](){} = " + rotate(0, "[](){}"));
        System.out.println("rotate(1, \"[](){}\"): ](){}[ = " + rotate(1, "[](){}"));
        System.out.println("rotate(5, \"[](){}\"): }[](){ = " + rotate(5, "[](){}"));

        System.out.println("matched(\"[\",\"]\"): true = " + matched("[","]"));
        System.out.println("matched(\"]\",\"[\"): false = " + matched("]","["));

        System.out.println("isRightString(\"[](){}\"): true = " + isRightString("[](){}"));

        System.out.println("countAllX(\"[](){}\"): 3 = " + countAllX("[](){}"));
    }

    public int solution(String s) {
        // test();
        int answer = countAllX(s);
        return answer;
    }

    public String rotate(int times, String string) {
        return string.substring(times) + string.substring(0, times);
    }

    public boolean matched(String string1, String string2) {
        if (string1.equals("[")) {
            if (string2.equals("]")) {
                return true;
            }
        }

        if (string1.equals("{")) {
            if (string2.equals("}")) {
                return true;
            }
        }

        if (string1.equals("(")) {
            if (string2.equals(")")) {
                return true;
            }
        }

        return false;
    }

    public boolean isRightString(String string) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < string.length(); i += 1) {
            if (stack.size() == 0) {
                stack.push(string.substring(i, i + 1));
                continue;
            }

            if (matched(stack.get(stack.size() - 1), string.substring(i, i + 1))) {
                stack.pop();
                continue;
            }

            stack.push(string.substring(i, i + 1));
        }

        if (stack.size() == 0) {
            return true;
        }

        return false;
    }

    public int countAllX(String string) {
        int count = 0;

        for (int i = 0; i < string.length(); i += 1) {
            if (isRightString(rotate(i, string))) {
                count += 1;
            }
        }

        return count;
    }
}
