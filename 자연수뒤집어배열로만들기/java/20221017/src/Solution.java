import java.util.stream.IntStream;

class Solution {
    public int[] solution(long n) {
        String number = String.valueOf(n);

        return IntStream.range(0,number.length())
                .map(i -> Integer.valueOf(number.substring(number.length() - i - 1, number.length() - i)))
                .toArray();
    }
}
