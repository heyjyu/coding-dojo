class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] primeNumbers = new int[n - 1];
        boolean isPrime = true;

        for (int i = 2; i <= n; i += 1) {
            for (int j = 0; j < answer; j += 1) {
                isPrime = false;

                if (i % primeNumbers[j] == 0) {
                    break;
                }

                if (primeNumbers[j] > Math.sqrt(i)) {
                    primeNumbers[answer] = i;
                    answer += 1;

                    break;
                }

                isPrime = true;
            }

            if (isPrime) {
                primeNumbers[answer] = i;
                answer += 1;
            }
        }

        return answer;
    }
}
