import java.util.stream.IntStream;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = removeDuplicates(arr);

        return answer;
    }

    public int[] removeDuplicates(int[] numbers) {
        return IntStream.range(0, numbers.length)
                .filter(i -> i == 0 || numbers[i - 1] != numbers[i])
                .map(i -> numbers[i])
                .toArray();
    }
}
