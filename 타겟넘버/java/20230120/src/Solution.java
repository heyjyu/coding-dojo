class Solution {
    public static int result = 0;

    public void test() {
        System.out.println("solution(new int[]{1,1,1,1,1}, 3): 5 = " + solution(new int[]{1,1,1,1,1}, 3));
    }

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        int answer = result;
        return answer;
    }

    public int dfs(int[] numbers, int target, int index, int sum) {
        if (index == numbers.length) {
            if (sum == target) {
                result += 1;
            }
        }

        dfs(numbers, target, index + 1, sum + numbers[index]);
        dfs(numbers, target, index + 1, sum - numbers[index]);
    }
}
