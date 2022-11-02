import java.util.*;
import java.util.stream.*;

class Solution3 {
    public void test() {
        System.out.println("initialCount(5, new int[]{1,4}, new int[]{1,3,5}): List.of(1,1,2,0,2) = " + initialCount(5, new int[]{1, 4}, new int[]{1, 3, 5}).toString());

        System.out.println("processedCount(initialCount(5, new int[]{1,4}, new int[]{1,3,5})): List.of(1,1,1,1,2) = " + processedCount(initialCount(5, new int[]{1, 4}, new int[]{1, 3, 5})));

        System.out.println("processedCount(initialCount(5, new int[]{2,4}, new int[]{3})): List.of(1,1,1,0,1) = " + processedCount(initialCount(5, new int[]{2, 4}, new int[]{3})));

        System.out.println("processedCount(initialCount(4, new int[]{2,3}, new int[]{3,4})): List.of(1,0,1,2) = " + processedCount(initialCount(4, new int[]{2, 3}, new int[]{3, 4})));

        System.out.println("process(4, new int[]{2,3}, new int[]{3,4}): 3 = " + process(4, new int[]{2, 3}, new int[]{3, 4}));

        System.out.println("process(8, new int[]{2,4,5,7}, new int[]{1,3,6,8}): 8 = " + process(8, new int[]{2, 4, 5, 7}, new int[]{1, 3, 6, 8}));

        System.out.println("process(3, new int[]{3}, new int[]{1}): 2 = " + process(3, new int[]{3}, new int[]{1}));
    }

    public int solution(int n, int[] lost, int[] reserve) {
        // test();
        int answer = process(n, lost, reserve);
        return answer;
    }

    public List<Integer> initialCount(int n, int[] lost, int[] reserve) {
        List<Integer> lostList = Arrays.stream(lost).boxed().collect(Collectors.toList());
        List<Integer> reserveList = Arrays.stream(reserve).boxed().collect(Collectors.toList());

        return IntStream.range(1, n + 1)
                .map((i) -> {
                    int count = 1;

                    if (lostList.contains(i)) {
                        count -= 1;
                    }

                    if (reserveList.contains(i)) {
                        count += 1;
                    }

                    return count;
                })
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> processedCount(List<Integer> initialCount) {
        List<Integer> processedList = new ArrayList<>(initialCount);

        IntStream.range(0, initialCount.size())
                .filter(i -> initialCount.get(i) == 0)
                .sorted()
                .forEach(i -> {
                    if (i > 0 && processedList.get(i - 1) > 1) {
                        processedList.set(i - 1, 1);

                        processedList.set(i, 1);

                        return;
                    }

                    if (i < processedList.size() - 1 && processedList.get(i + 1) > 1) {
                        processedList.set(i + 1, 1);

                        processedList.set(i, 1);
                    }
                });

        return processedList;
    }

    public int process(int n, int[] lost, int[] reserve) {
        return (int) processedCount(initialCount(n, lost, reserve)).stream()
                .filter(i -> i > 0)
                .count();
    }
}
