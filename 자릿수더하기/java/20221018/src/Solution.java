import java.util.stream.IntStream;

public class Solution {
    public int solution(int n) {
        int answer = addDigits(n);

        return answer;
    }

    public int addDigits(int n) {
        String number = String.valueOf(n);
        return IntStream.range(0, number.length())
                .reduce(0, (accumulator, i) -> accumulator + Integer.parseInt(number.substring(i, i + 1)));
    }
}
