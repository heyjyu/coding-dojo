class Solution {
    public String solution(int n) {
        String answer = print(n);
        return answer;
    }

    public boolean isEven(int n) {
        if (n % 2 == 0) {
            return true;
        }

        return false;
    }

    public String print(int n) {
        String answer = "";

        if (isEven(n)) {
            for (int i = 0; i < n / 2; i += 1) {
                answer += "수박";
            }

            return answer;
        }

        for (int i = 0; i < (n - 1) / 2; i += 1) {
            answer += "수박";
        }

        answer += "수";

        return answer;
    }
}
