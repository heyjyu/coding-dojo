import java.util.*;
import java.util.stream.*;

class Solution {
    public void test() {
        System.out.println("matchedCount(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19}): 2 = " + matchedCount(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19}));

        System.out.println("zeroCount(new int[]{44, 1, 0, 0, 31, 25}): 2 = " + zeroCount(new int[]{44, 1, 0, 0, 31, 25}));

        System.out.println("highestAndLowestPlace(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19}): [3,5] = " + highestAndLowestPlace(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19}));

        System.out.println("computePlace(1): 6 = " + computePlace(1));
        System.out.println("computePlace(0): 6 = " + computePlace(0));
        System.out.println("computePlace(6): 1 = " + computePlace(6));
    }

    public int[] solution(int[] lottos, int[] win_nums) {
        // test();
        int[] answer = highestAndLowestPlace(lottos, win_nums);
        return answer;
    }

    public int matchedCount(int[] lottos, int[] win_nums) {
        List<Integer> winNumbers = Arrays.stream(win_nums).boxed().collect(Collectors.toList());

        return Arrays.stream(lottos)
                .filter(number -> winNumbers.contains(number))
                .toArray()
                .length;
    }

    public int zeroCount(int[] lottos) {
        return Arrays.stream(lottos)
                .filter(number -> number == 0)
                .toArray()
                .length;
    }

    public int[] highestAndLowestPlace(int[] lottos, int[] win_nums) {
        int lowestCount = matchedCount(lottos, win_nums);
        int zeroNumberCount = zeroCount(lottos);
        int highestCount = lowestCount + zeroNumberCount;

        return new int[]{computePlace(highestCount), computePlace(lowestCount)};
    }

    public int computePlace(int matchCount) {
        return switch (matchCount) {
            case 6 -> 1;
            case 5 -> 2;
            case 4 -> 3;
            case 3 -> 4;
            case 2 -> 5;
            default -> 6;
        };
    }
}
