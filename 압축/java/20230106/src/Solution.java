import java.util.*;
import java.util.stream.*;

class Solution {
    public void test() {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i += 1) {
            map.put(Character.toString('A' + i), i + 1);
        }

        System.out.println("findWLength(\"TOBEORNOTTOBEORTOBEORNOT\", map): 1 = " + findWLength("TOBEORNOTTOBEORTOBEORNOT", map));
        map.put("TO", 27);
        System.out.println("findWLength(\"OBEORNOTTOBEORTOBEORNOT\", map): 1 = " + findWLength("OBEORNOTTOBEORTOBEORNOT", map));
        map.put("OB", 28);
        System.out.println("findWLength(\"BEORNOTTOBEORTOBEORNOT\", map): 1 = " + findWLength("BEORNOTTOBEORTOBEORNOT", map));
        map.put("BE", 29);
        System.out.println("findWLength(\"EORNOTTOBEORTOBEORNOT\", map): 1 = " + findWLength("EORNOTTOBEORTOBEORNOT", map));
        map.put("EO", 30);
        System.out.println("findWLength(\"ORNOTTOBEORTOBEORNOT\", map): 1 = " + findWLength("ORNOTTOBEORTOBEORNOT", map));
        map.put("OR", 31);
        System.out.println("findWLength(\"RNOTTOBEORTOBEORNOT\", map): 1 = " + findWLength("RNOTTOBEORTOBEORNOT", map));
        map.put("RN", 32);
        System.out.println("findWLength(\"NOTTOBEORTOBEORNOT\", map): 1 = " + findWLength("NOTTOBEORTOBEORNOT", map));
        map.put("NO", 33);
        System.out.println("findWLength(\"OTTOBEORTOBEORNOT\", map): 1 = " + findWLength("OTTOBEORTOBEORNOT", map));
        map.put("OT", 34);
        System.out.println("findWLength(\"TTOBEORTOBEORNOT\", map): 1 = " + findWLength("TTOBEORTOBEORNOT", map));
        map.put("TT", 35);
        System.out.println("findWLength(\"TOBEORTOBEORNOT\", map): 2 = " + findWLength("TOBEORTOBEORNOT", map));
        map.put("TOB", 36);
        System.out.println("findWLength(\"BEORTOBEORNOT\", map): 2 = " + findWLength("BEORTOBEORNOT", map));
        map.put("BEO", 37);
        System.out.println("findWLength(\"ORTOBEORNOT\", map): 2 = " + findWLength("ORTOBEORNOT", map));
        map.put("ORT", 38);
        System.out.println("findWLength(\"TOBEORNOT\", map): 3 = " + findWLength("TOBEORNOT", map));
        map.put("TOBE", 39);
        System.out.println("findWLength(\"EORNOT\", map): 2 = " + findWLength("EORNOT", map));

        System.out.println("findIndices(\"KAKAO\"): [11,1,27,15] = " + Arrays.stream(findIndices("KAKAO")).boxed().collect(Collectors.toList()));
        System.out.println("findIndices(\"TOBEORNOTTOBEORTOBEORNOT\"): [20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34] = " + Arrays.stream(findIndices("TOBEORNOTTOBEORTOBEORNOT")).boxed().collect(Collectors.toList()));
    }

    public int[] solution(String msg) {
        test();
        int[] answer = {};
        return answer;
    }

    public int findWLength(String msg, Map<String, Integer> map) {
        if (map.getOrDefault(msg, -1) > 0) {
            return msg.length();
        }

        for (int i = 0; i < msg.length(); i += 1) {
            int index = map.getOrDefault(msg.substring(0, i + 1), -1);

            if (index < 0) {
                return i;
            }
        }

        return -1;
    }

    public int[] findIndices(String msg) {
        Map<String, Integer> dictionary = new HashMap<>();
        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i < 26; i += 1) {
            dictionary.put(Character.toString('A' + i), i + 1);
        }

        while (msg.length() > 0) {
            int wLength = findWLength(msg, dictionary);

            String w = msg.substring(0, wLength);
            indices.add(dictionary.get(w));
            msg = msg.substring(wLength);
            if (msg.length() > 0) {
                dictionary.put(w + msg.substring(0, 1), dictionary.size() + 1);
            }
        }

        return indices.stream().mapToInt(Integer::valueOf).toArray();
    }
}
