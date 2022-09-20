class Solution {
    public boolean solution(int x) {
        return x % addDigits(String.valueOf(x)) == 0;
    }

    public int addDigits(String number) {
        int result = 0;

        for (int i = 0; i < number.length(); i += 1) {
            result += Integer.valueOf(number.substring(i, i + 1));
        }

        return result;
    }
}
