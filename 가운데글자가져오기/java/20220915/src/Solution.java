class Solution {
    public String solution(String s) {
        String answer;
        int centerIndex = s.length() / 2;

        if (s.length() % 2 == 1) {
            answer = String.valueOf(s.charAt(centerIndex));

            return answer;
        }

        answer = s.charAt(centerIndex - 1) + String.valueOf(s.charAt(centerIndex));

        return answer;
    }
}
