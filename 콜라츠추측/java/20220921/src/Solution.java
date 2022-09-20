class Solution {
    public int solution(int num) {
        int answer = countToOne(num);

        return answer;
    }

    public boolean isEven(long number) {
        return number % 2 == 0;
    }

    public long process(long number) {
        if (isEven(number)) {
            return number / 2;
        }

        return number * 3 + 1;
    }

    public int countToOne(long number) {
        int count = 0;

        while (number != 1) {
            number = process(number);
            count += 1;

            if (count == 500) {
                return -1;
            }
        }

        return count;
    }
}
