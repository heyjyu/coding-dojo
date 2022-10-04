import java.util.stream.IntStream;

class Solution {
    public long solution(int price, int money, int count) {
        long answer = process(price, money, count);

        return answer;
    }

    public long totalPrice(long price, long count) {
        return IntStream.range(1, Math.toIntExact(count) + 1)
                .sum() * price;
    }

    public long process(long price, long money, long count) {
        if (money > totalPrice(price, count)) {
            return 0;
        }

        return totalPrice(price, count) - money;
    }
}
