import java.util.*;

class Solution {
    public void test() {
        System.out.println("removable(\"baabaa\"): 1 = " + removable("baabaa"));
        System.out.println("removable(\"cdcd\"): 0 = " + removable("cdcd"));
    }

    public int solution(String s) {
        // test();

        int answer = removable(s);

        return answer;
    }

    public int removable(String s) {
        List<String> stack = new ArrayList<>();

        for (String i : s.split("")) {
            if (stack.size() == 0) {
                stack.add(i);

                continue;
            }

            if (stack.get(stack.size() - 1).equals(i)) {
                stack.remove(stack.size() - 1);

                continue;
            }

            stack.add(i);
        }

        return stack.size() == 0
                ? 1
                : 0;
    }
}
