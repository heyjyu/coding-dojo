class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int smallValue = a;
        int biggerValue = b;

        if (a > b) {
            smallValue = b;
            biggerValue = a;
        }

        for (int i = smallValue; i <= biggerValue; i += 1) {
            answer += i;
        }

        return answer;
    }
}
