class Solution {
    public void test() {
        System.out.println("remainder(4): 5 = " + remainder(4));
    }

    public long solution(int n) {
        test();
        long answer = remainder(n);
        return answer;
    }

    public long remainder(int n) {
        long[] memo = new long[n + 1];
        memo[0] = 1L;
        memo[1] = 2L;

        for (int i = 2; i < n; i += 1) {
            memo[i] = (memo[i - 1] + memo[i - 2]) % 1234567;
        }

        return memo[n - 1];
    }
}
