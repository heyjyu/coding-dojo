class Solution {
    public String solution(String s) {
        String answer = process(s);
        return answer;
    }

    public String process(String string) {
        String processedString = "";

        int index = 0;

        for (int i = 0; i < string.length(); i += 1) {
            if (string.charAt(i) != 32) {
                if (index % 2 == 0) {
                    processedString += string.substring(i, i + 1).toUpperCase();
                    index += 1;
                    continue;
                }
                processedString += string.substring(i, i + 1).toLowerCase();
                index += 1;
                continue;
            }
            processedString += string.substring(i, i + 1);
            index = 0;
        }

        return processedString;
    }
}
