import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = process(d, budget);
        return answer;
    }

    public int[] sort(int[] numbers) {
        return Arrays.stream(numbers)
                .sorted()
                .toArray();
    }

    public int process(int[] array, int budget) {
        int[] sortedArray = sort(array);

        return IntStream.range(0, sortedArray.length)
                .map(i -> sumToIndex(sortedArray, i))
                .filter(sum -> sum <= budget)
                .toArray()
                .length;
    }

    public int sumToIndex(int[] array, int index) {
        return IntStream.rangeClosed(0, index)
                .map(i -> array[i])
                .sum();
    }
}
