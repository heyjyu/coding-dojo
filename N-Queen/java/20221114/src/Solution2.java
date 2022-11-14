class Solution2 {
    public void test() {
        System.out.println("possible(2,new int[]{1,3,0,0}): true = " + possible(2, new int[]{1,3,0,0}));
        System.out.println("possible(2,new int[]{1,3,2,0}): false = " + possible(2, new int[]{1,3,2,0}));
        System.out.println("backTrack(0, new int[]{0,0,0,0}): 2 = " + backTrack(0, new int[]{0,0,0,0}));
        System.out.println("backTrack(0, new int[]{0,0,0,0,0}): 10 = " + backTrack(0, new int[]{0,0,0,0,0}));
    }

    public int solution(int n) {
        int[] array = new int[n];
        int result = backTrack(0, array);
        // test();
        return result;
    }

    public int backTrack(int level, int[] array) {
        int count = 0;

        if (level == array.length) {
            return 1;
        }

        for (int i = 0; i < array.length; i += 1) {
            array[level] = i;
            if (possible(level, array)) {
                count += backTrack(level + 1, array);
            }
        }

        return count;
    }

    public boolean possible(int level, int[] array) {
        for (int i = 0; i < level; i += 1) {
            if (array[i] == array[level] || Math.abs(array[level]-array[i]) == Math.abs(level-i)) {
                return false;
            }
        }

        return true;
    }
}
