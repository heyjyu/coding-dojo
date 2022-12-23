import java.util.*;

class Solution {
    public void test() {
        System.out.println("nextNumber(78): 83 = " + nextNumber(78));
        System.out.println("nextNumber(15): 23 = " + nextNumber(15));

        System.out.println("countOne(\"1101\"): 3 = " + countOne("1101"));
    }

    public int solution(int n) {
        // test();
        int answer = nextNumber(n);
        return answer;
    }

    public int countOne(String string) {
        int count = 0;

        char[] charArray = string.toCharArray();

        for (int i = 0; i < charArray.length; i += 1) {
            if (charArray[i] == '1') {
                count += 1;
            }
        }
        return count;
    }

    public int nextNumber(int number) {
        int nextNumber = number;
        while (true) {
            nextNumber += 1;

            if (countOne(Integer.toBinaryString(number)) == countOne(Integer.toBinaryString(nextNumber))) {
                return nextNumber;
            }
        }
    }
}
