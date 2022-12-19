import java.util.*;

class Solution {
    public void test() {
        System.out.println("countOfZero(\"0110\"): 2 = " + countOfZero("0110"));

        System.out.println("convertTo1(\"0111010\"): 2 = " + convertTo1("0111010")[0]);
        System.out.println("convertTo1(\"0111010\"): 5 = " + convertTo1("0111010")[1]);
    }

    public int[] solution(String s) {
        // test();
        int[] answer = convertTo1(s);
        return answer;
    }

    public int countOfZero(String string) {
        return (int) Arrays.stream(string.split(""))
                .filter(character -> character.equals("0"))
                .count();
    }

    public int[] convertTo1(String string) {
        int convertCount = 0;
        int removedZero = 0;

        while (!string.equals("1")) {
            convertCount += 1;

            int countOfOne = string.length() - countOfZero(string);

            removedZero += countOfZero(string);

            string = Integer.toBinaryString(countOfOne);
        }

        return new int[] {convertCount, removedZero};
    }
}
