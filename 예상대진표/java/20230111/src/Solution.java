class Solution {
    public void test() {
        System.out.println("matched(2,4): false = " + matched(2, 4));
        System.out.println("matched(3,4): true = " + matched(3, 4));
        System.out.println("matched(2,3): false = " + matched(2, 3));

        System.out.println("nextNumber(4): 2 = " + nextNumber(4));
        System.out.println("nextNumber(3): 2 = " + nextNumber(3));

        System.out.println("computeMatchRound(4, 7): 3 = " + computeMatchRound(4, 7));
    }

    public int solution(int n, int a, int b) {
        test();
        int answer = computeMatchRound(a, b);

        return answer;
    }

    public boolean matched(int x, int y) {
        int max = x > y ? x : y;
        int min = x > y ? y : x;

        if (max - min != 1) {
            return false;
        }

        if (max % 2 == 0) {
            return true;
        }

        return false;
    }

    public int nextNumber(int number) {
        return (int) Math.floor((number + 1) / 2);
    }

    public int computeMatchRound(int x, int y) {
        int currentXNumber = x;
        int currentYNumber = y;
        int round = 1;

        while (true) {
            if (matched(currentXNumber, currentYNumber)) {
                return round;
            }

            round += 1;
            currentXNumber = nextNumber(currentXNumber);
            currentYNumber = nextNumber(currentYNumber);
        }
    }
}
