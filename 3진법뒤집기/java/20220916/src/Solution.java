class Solution {
    public int solution(int n) {
        int answer = 0;
        return answer;
    }

    public String convertTo3reversed(int number) {
        String convertedValue = "";

        int quotient = number / 3;
        int remainder = number % 3;
        convertedValue += String.valueOf(remainder);

        while (quotient >= 3) {
            remainder = quotient % 3;
            quotient = quotient / 3;

            convertedValue += remainder;
        }

        convertedValue += String.valueOf(quotient);

        return convertedValue;
    }
}
