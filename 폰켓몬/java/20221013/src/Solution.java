import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        int answer = process(nums);

        return answer;
    }

    public int numberOfTypes(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        Arrays.stream(numbers)
                .forEach(number -> set.add(number));

        return set.size();
    }

    public int process(int[] numbers) {
        int largestAnswer = numbers.length / 2;
        int numberOfTypes = numberOfTypes(numbers);

        return numberOfTypes < largestAnswer
                ? numberOfTypes
                : largestAnswer;
    }
}
