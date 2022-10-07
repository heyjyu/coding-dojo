class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = map(n, arr1, arr2);
        return answer;
    }

    public String base2(int number) {
        return Integer.toBinaryString(number);
    }

    public String row(int length, int value) {
        String row = "";
        String base2 = String.valueOf(base2(value));

        int paddingLength = length - base2.length();

        for (int i = 0; i < paddingLength; i += 1) {
            row = "0" + row;
        }

        row += base2;

        return row;
    }

    public String processRow(int length, int value1, int value2) {
        String row1 = row(length, value1);
        String row2 = row(length, value2);

        String processedRow = "";

        for (int i = 0; i < length; i += 1) {
            processedRow += Long.valueOf(row1.substring(i, i + 1)) | Long.valueOf(row2.substring(i, i + 1));
        }

        return processedRow;
    }

    public String toMapRow(String row) {
        String mapRow = "";

        for (int i = 0; i < row.length(); i += 1) {
            mapRow += row.charAt(i) == '1' ? "#" : " ";
        }

        return mapRow;
    }

    public String[] map(int length, int[] array1, int[] array2) {
        String[] map = new String[length];

        for (int i = 0; i < length; i += 1) {
            map[i] = toMapRow(processRow(length, array1[i], array2[i]));
        }

        return map;
    }
}
