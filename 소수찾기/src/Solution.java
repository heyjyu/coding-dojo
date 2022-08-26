class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] primeNumbers = new int[n];
        int j;

        for (int i = 2; i <= n; i += 1) {
            for (j = 0; j < answer; j += 1) {
                if (i % primeNumbers[j] == 0) {
                    break;
                }
            }

            if (j == answer) {
                primeNumbers[answer] = i;
                answer += 1;
            }
        }

        return answer;
    }
}
