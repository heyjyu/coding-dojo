class Solution {
    public void test() {
        System.out.println("canAddUpToN(1, 15): true = " + canAddUpToN(1, 15));
        System.out.println("canAddUpToN(2, 15): false = " + canAddUpToN(2, 15));

        System.out.println("countAllPossibilities(15): 4 = " + countAllPossibilities(15));
    }

    public int solution(int n) {
        // test();
        int answer = countAllPossibilities(n);
        return answer;
    }

    public boolean canAddUpToN(int start, int target) {
        int amount = 0;

        for (int i = 0; i < target; i += 1) {
            amount += start + i;

            if (amount == target) {
                return true;
            }

            if (amount > target) {
                return false;
            }
        }

        return false;
    }

    public int countAllPossibilities(int target) {
        int count = 0;

        for (int i = 1; i < target + 1; i += 1) {
            if (canAddUpToN(i, target)) {
                count += 1;
            }
        }

        return count;
    }
}
