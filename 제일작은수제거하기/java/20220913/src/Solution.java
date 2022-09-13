class Solution {
    public int[] solution(int[] arr) {
        int[] answer;

        if (arr.length == 1) {
            answer = new int[]{-1};

            return answer;
        }

        answer = new int[arr.length - 1];
        int leastValue = arr[0];
        int index = 0;

        for (int number : arr) {
            if (leastValue > number) {
                leastValue = number;
            }
        }

        for (int number : arr) {
            if (number == leastValue) {
                continue;
            }

            answer[index] = number;
            index += 1;
        }

        return answer;
    }
}
