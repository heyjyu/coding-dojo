class Solution {
    public int solution(int n) {
        int largestAnswer = n - 1;

        for (int i = 2; i <= Math.sqrt(largestAnswer); i += 1) {
            if (largestAnswer % i == 0) {
                return i;
            }
        }

        return largestAnswer;
    }
}
