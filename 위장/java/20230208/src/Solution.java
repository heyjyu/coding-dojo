import java.util.*;
import java.util.stream.*;

class Solution {
    public void test() {
        System.out.println("mapOfClothes(new String[][]{{\"yellow_hat\", \"headgear\"}, {\"blue_sunglasses\", \"eyewear\"}, {\"green_turban\", \"headgear\"}}): {eyewear=[blue_sunglasses], headgear=[yellow_hat, green_turban]} = " + mapOfClothes(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));

        System.out.println("countAllPossibilities(new String[][]{{\"yellow_hat\", \"headgear\"}, {\"blue_sunglasses\", \"eyewear\"}, {\"green_turban\", \"headgear\"}}): 5 = " + countAllPossibilities(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
        System.out.println("countAllPossibilities(new String[][]{{\"yellow_hat\", \"headgear\"}, {\"blue_sunglasses\", \"headgear\"}, {\"green_turban\", \"headgear\"}, {\"blue_turban\", \"headgear\"}}): 4 = " + countAllPossibilities(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "headgear"}, {"green_turban", "headgear"}, {"blue_turban", "headgear"}}));
    }

    public int solution(String[][] clothes) {
        // test();
        int answer = countAllPossibilities(clothes);
        return answer;
    }

    public Map<String, List<String>> mapOfClothes(String[][] clothes) {
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i += 1) {
            List<String> list = map.getOrDefault(clothes[i][1], new ArrayList<String>());
            list.add(clothes[i][0]);
            map.put(clothes[i][1], list);
        }

        return map;
    }

    public int countAllPossibilities(String[][] clothes) {
        Map<String, List<String>> map = mapOfClothes(clothes);
        List<Integer> numberOfTypes = map.keySet().stream()
                .map(key -> map.get(key).size())
                .collect(Collectors.toList());

        int count = 1;

        for (int i = 0; i < numberOfTypes.size(); i += 1) {
            count *= (numberOfTypes.get(i) + 1);
        }

        return count - 1;
    }
}
