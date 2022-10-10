import java.util.Arrays;

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

        int usedBudget = 0;

        for (int i = 0; i < sortedArray.length; i += 1) {
            usedBudget += sortedArray[i];
            if (usedBudget > budget) {
                return i;
            }
        }

        return sortedArray.length;
    }
}
