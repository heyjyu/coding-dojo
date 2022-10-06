import java.util.stream.IntStream;

class Solution {
    public int solution(int n) {
        int answer = process(n);
        return answer;
    }

    public int smallestDivisor(int n) {
        return IntStream.rangeClosed(2, n)
                .filter(i -> n % i == 0)
                .findFirst().getAsInt();
    }

    public int process(int n) {
        return smallestDivisor(n - 1);
    }
}
