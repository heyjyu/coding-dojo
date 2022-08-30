class Solution {
    public double solution(int[] arr) {
        double answer = 0;

        for (int number :  arr) {
            answer += number;
        }

        answer /= arr.length;

        return answer;
    }
}
