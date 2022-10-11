import java.util.stream.IntStream;

class Solution {
    public int solution(int left, int right) {
        int answer = process(left, right);
        return answer;
    }

    public int numberOfDivisor(int number) {
        return (int) IntStream.rangeClosed(1, number)
                .filter(i -> number % i == 0)
                .count();
    }

    public int process(int left, int right) {
        return IntStream.rangeClosed(left, right)
                .map(number -> numberOfDivisor(number) % 2 == 0
                        ? number
                        : -number)
                .reduce((accumulator, number) -> accumulator + number)
                .getAsInt();
    }
}
