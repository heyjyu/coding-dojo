class Solution {
    public String solution(String phone_number) {
        String answer = "";

        int numberOfAsterisk = phone_number.length() - 4;

        for (int i = 0; i < phone_number.length(); i += 1) {
            if (i < numberOfAsterisk) {
                answer += "*";

                continue;
            }

            answer += phone_number.charAt(i);
        }

        return answer;
    }
}
