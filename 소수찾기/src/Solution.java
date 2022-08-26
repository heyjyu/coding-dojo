class Solution {
    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i < n + 1; i += 1) {
            int half = i / 2;
            int j;

            for (j = 2; j <= half; j += 1){
                if (i % j == 0) {
                    break;
                }
            }

            if (j == half + 1) {
                answer += 1;
            }
        }

        return answer;
    }
}
