class Solution {
    public void test() {
        System.out.println("GCD(2, 6): 2 = " + GCD(2, 6));
        System.out.println("GCD(12, 14): 2 = " + GCD(12, 14));

        System.out.println("LCM(2, 6): 6 = " + LCM(2, 6));
        System.out.println("LCM(12, 14): 84 = " + LCM(12, 14));

        System.out.println("LCMOfArray(new int[]{2,6,8,14}): 168 = " + LCMOfArray(new int[]{2,6,8,14}));
    }

    public int solution(int[] arr) {
        test();

        return LCMOfArray(arr);
    }

    public int GCD(int x, int y) {
        int min = x > y ? y : x;
        int max = x > y ? x : y;

        int divisor = 1;

        for (int i = 1; i < min + 1; i += 1) {
            if (max % i == 0 && min % i == 0) {
                divisor = i;
            }
        }

        return divisor;
    }

    public int LCM(int x, int y) {
        return x * y / GCD(x, y);
    }

    public int LCMOfArray(int[] array) {
        int multiple = 1;

        for (int i = 0; i < array.length; i += 1) {
            multiple = LCM(multiple, array[i]);
        }

        return multiple;
    }
}
