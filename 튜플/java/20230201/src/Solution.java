import java.util.*;
import java.util.stream.*;

class Solution {
    public void test() {
        System.out.println("nextValue(new int[]{1,2,3},List.of(3,2)): 1 = " + nextValue(new int[]{1, 2, 3}, List.of(3, 2)));

        System.out.println("findTuple(\"{{2},{2,1},{2,1,3},{2,1,3,4}}\"): [2,1,3,4] = " + findTuple("{{2},{2,1},{2,1,3},{2,1,3,4}}"));

        System.out.println("findTuple(\"{{123}}\"): [123] = " + findTuple("{{123}}"));
    }

    public int[] solution(String s) {
        test();
        int[] answer = {};
        return answer;
    }

    public int nextValue(int[] array, List<Integer> tuple) {
        List<Integer> list = Arrays.stream(array)
                .boxed()
                .collect(Collectors.toList());

        for (int i : tuple) {
            list.remove(Integer.valueOf(i));
        }

        return list.get(0);
    }

    public int[] findTuple(String s) {
        String trimmedString = s.substring(2, s.length() - 2);

        String[] values = trimmedString.split("\\},\\{");

        Arrays.sort(values, (a, b) -> a.length() > b.length() ? 1 : -1);

        List<Integer> tuple = new ArrayList<>();

        for (int i = 0; i < values.length; i += 1) {
            System.out.println(Arrays.stream(values.split(",")).mapToInt(i -> Integer.valueOf(i)).toArray());
            tuple.add(nextValue(List.of(1), tuple));
        }

        return tuple.stream().toArray();
    }
}
