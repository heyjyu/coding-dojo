class Solution {
    public int climbStairs(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        if (n < 3) {
            return list.get(n - 1);
        }

        for (int i = 2; i < n; i += 1) {
            list.add(list.get(i - 2) + list.get(i - 1));
        }

        return list.get(n - 2) + list.get(n - 3);
    }
}
