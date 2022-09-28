class Solution {
    public String solution(String s) {
        String answer = reverseSort(s);
        return answer;
    }

    public String reverseSort(String string) {
        for (int i = 0; i < string.length() ; i += 1) {
            for (int j = i; j < string.length(); j += 1) {
                if (string.charAt(i) < string.charAt(j)) {
                    string = swap(string, i , j);
                }
            }
        }

        return string;
    }

    public String swap(String string, int i, int j) {
        char[] charArray = string.toCharArray();
        char temp = string.charAt(i);

        charArray[i] = string.charAt(j);
        charArray[j] = temp;

        return String.valueOf(charArray);
    }
}
