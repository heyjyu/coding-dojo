import java.util.*;

class Solution {
    public void test() {
        System.out.println("replaceCharacter(\"one4\"): 14 = " +
                replaceCharacter("one4"));
        System.out.println("replaceCharacter(\"one4seveneight\"): 1478 = " +
                replaceCharacter("one4seveneight"));
    }

    public int solution(String s) {
        // test();
        int answer = replaceCharacter(s);
        return answer;
    }

    public int replaceCharacter(String string) {
        Map<String, String> map = new HashMap<>();
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");

        String newString = map.keySet().stream()
                .reduce(string, (acc, key) -> acc.replace(key, map.get(key)));

        return Integer.valueOf(newString);
    }
}
