class Solution {
    public void test() {
        System.out.println("isPivotIndex(new int[]{1,7,3,6,5,6},3): true = " + isPivotIndex(new int[]{1,7,3,6,5,6},3));

        System.out.println("getPivotIndex(new int[]{1,7,3,6,5,6}): 3 = " + getPivotIndex(new int[]{1,7,3,6,5,6}));
    }

    public int pivotIndex(int[] nums) {
        // test();
        return getPivotIndex(nums);
    }

    public boolean isPivotIndex(int[] nums, int index) {
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < index; i += 1) {
            leftSum += nums[i];
        }

        for (int i = index + 1; i < nums.length; i += 1) {
            rightSum += nums[i];
        }

        return leftSum == rightSum;
    }

    public int getPivotIndex(int [] nums) {
        for (int i = 0; i < nums.length; i += 1) {
            if (isPivotIndex(nums, i)) {
                return i;
            }
        }

        return -1;
    }
}
