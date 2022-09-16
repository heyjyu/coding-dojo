class Solution {
    public int solution(int n) {
        int answer = convertTo10(convertTo3reversed(n));

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

        if (quotient > 0) {
            convertedValue += String.valueOf(quotient);
        }

        return convertedValue;
    }

    public int convertTo10(String number) {
        int convertedValue = 0;

        for (int i = 0; i < number.length(); i += 1) {
            int valueOfPosition = (int) Math.pow(3, number.length() - i - 1);
            int power = Integer.valueOf(number.substring(i, i + 1));
            convertedValue += power * valueOfPosition;
        }

        return convertedValue;
    }
}
