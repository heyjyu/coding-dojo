class Solution {
    public void test() {
        System.out.println("greatestCommonDivisor(2, 7): 1 = " + greatestCommonDivisor(2, 7));
        System.out.println("greatestCommonDivisor(2, 6): 2 = " + greatestCommonDivisor(2, 6));
        System.out.println("greatestCommonDivisor(6, 8): 2 = " + greatestCommonDivisor(6, 8));
        System.out.println("greatestCommonDivisor(3, 2): 1 = " + greatestCommonDivisor(3, 2));
        System.out.println("greatestCommonDivisor(1, 1): 1 = " + greatestCommonDivisor(1, 1));

        System.out.println("computeLCMForTwo(1,2): 2 = " + computeLCMForTwo(1, 2));
        System.out.println("computeLCMForTwo(2,7): 14 = " + computeLCMForTwo(2, 7));

        System.out.println("computeLCMForAll(new int[] {2,6,8,14}): 168 = " + computeLCMForAll(new int[]{2, 6, 8, 14}));
        System.out.println("computeLCMForAll(new int[] {1,2,3}): 6 = " + computeLCMForAll(new int[]{1, 2, 3}));

    }

    public int solution(int[] arr) {
        // test();
        int answer = computeLCMForAll(arr);
        return answer;
    }

    public int greatestCommonDivisor(int x, int y) {
        if (x == y) {
            return x;
        }

        if (x > y) {
            if (x % y == 0) {
                return y;
            }

            return greatestCommonDivisor(y, x % y);
        }

        return greatestCommonDivisor(y, x);
    }

    public int computeLCMForTwo(int x, int y) {
        return x * y / greatestCommonDivisor(x, y);
    }

    public int computeLCMForAll(int[] numbers) {
        int result = 1;

        for (int i = 0; i < numbers.length; i += 1) {
            result = computeLCMForTwo(result, numbers[i]);
        }

        return result;
    }
}
