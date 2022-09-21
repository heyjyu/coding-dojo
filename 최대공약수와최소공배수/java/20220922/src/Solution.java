import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = {greatestCommonFactor(n, m), leastCommonMultiple(n, m)};
        return answer;
    }

    public boolean isDivisor(int number, int divisor) {
        return number % divisor == 0;
    }

    public int greatestCommonFactor(int number1, int number2) {
        int greatestCommonFactor = 1;

        for (int factor : factors(min(number1, number2))) {
            if (isDivisor(max(number1, number2), factor)) {
                if (factor > greatestCommonFactor) {
                    greatestCommonFactor = factor;
                }
            }
        }

        return greatestCommonFactor;
    }

    public List<Integer> factors(int number) {
        List<Integer> factors = new ArrayList<>();

        for (int i = 1; i < number + 1; i += 1) {
            if (isDivisor(number, i)) {
                factors.add(i);
            }
        }

        return factors;
    }

    public int min(int number1, int number2) {
        if (number1 < number2) {
            return number1;
        }

        return number2;
    }

    public int max(int number1, int number2) {
        if (number1 > number2) {
            return number1;
        }

        return number2;
    }

    public int leastCommonMultiple(int number1, int number2) {
        return number1 * number2 / greatestCommonFactor(number1, number2);
    }
}
