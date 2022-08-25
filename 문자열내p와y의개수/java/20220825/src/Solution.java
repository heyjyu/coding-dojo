class Solution {
    boolean solution(String s) {
        String[] parsedS = s.toLowerCase().split("");
        int numberOfP = 0;
        int numberOfY = 0;
        boolean answer = true;

        for (int i = 0; i < parsedS.length; i += 1) {
            if (parsedS[i].equals("p")) {
                numberOfP += 1;
            }

            if (parsedS[i].equals("y")) {
                numberOfY += 1;
            }
        }

        if (numberOfP != numberOfY) {
            answer = false;
        }

        return answer;
    }
}
