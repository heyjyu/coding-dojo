import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = multiples(arr, divisor);
        return answer;
    }

    public boolean isMultiple(int number, int divisor) {
        if (number % divisor == 0) {
            return true;
        }

        return false;
    }

    public int[] multiples(int[] array, int divisor) {
        int[] multiples = Arrays.stream(array).filter(number -> isMultiple(number, divisor)).sorted().toArray();

        if (multiples.length == 0) {
            multiples = new int[]{-1};
        }
        return multiples;
    }
}
