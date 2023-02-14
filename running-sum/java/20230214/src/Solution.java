class Solution {
    public void test() {
        System.out.println("fillValue(new int[]{1,2,3,4}, new int[]{1,3,0,0}, 2): {1,3,6,0}" + fillValue(new int[]{1,2,3,4}, new int[]{1,3,0,0}, 2));
    }

    public int[] runningSum(int[] nums) {
        // test();
        int[] values = new int[nums.length];

        for (int i = 0; i < nums.length; i += 1) {
            values = fillValue(nums, values, i);
        }

        return values;
    }

    public int[] fillValue(int[] nums, int[] values, int index) {
        if (index == 0) {
            values[index] = nums[index];
            return values;
        }

        values[index] = values[index - 1] + nums[index];

        return values;
    }
}
