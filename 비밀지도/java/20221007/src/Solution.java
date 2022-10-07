import java.util.Arrays;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = map(n, arr1, arr2);
        return answer;
    }

    public String base2(int number) {
        return Integer.toBinaryString(number);
    }

    public String processRow(int length, int value1, int value2) {
        return addZero(length, Integer.toBinaryString(value1 | value2));
    }

    public String toMapRow(String row) {
        return row.replace("0", " ").replace("1", "#");
    }

    public String[] map(int length, int[] array1, int[] array2) {
        String[] map = new String[length];

        for (int i = 0; i < length; i += 1) {
            map[i] = toMapRow(processRow(length, array1[i], array2[i]));
        }

        return map;
    }

    public String addZero(int length, String value) {
        return "0".repeat(length - value.length()) + value;
    }
}
