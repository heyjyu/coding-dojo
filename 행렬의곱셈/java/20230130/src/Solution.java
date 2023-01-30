import java.util.*;
import java.util.stream.*;

class Solution {
    public void test() {
        System.out.println("computeRow(new int[][]{{1,4},{3,2},{4,1}}, new int[][]{{3,3},{3,3}}, 0): {15,15} = " + Arrays.stream(computeRow(new int[][]{{1, 4}, {3, 2}, {4, 1}}, new int[][]{{3, 3}, {3, 3}}, 0))
                .boxed().collect(Collectors.toList()));
        System.out.println("computeRow(new int[][]{{2,3,2},{4,2,4},{3,1,4}}, new int[][]{{5,4,3},{2,4,1},{3,1,1}}, 0): {22,22,11} = " + Arrays.stream(computeRow(new int[][]{{2, 3, 2}, {4, 2, 4}, {3, 1, 4}}, new int[][]{{5, 4, 3}, {2, 4, 1}, {3, 1, 1}}, 0))
                .boxed().collect(Collectors.toList()));
    }

    public int[][] solution(int[][] arr1, int[][] arr2) {
//        test();
        int[][] answer = compute(arr1, arr2);
        return answer;
    }

    public int[] computeRow(int[][] arr1, int[][] arr2, int row) {
        int columnCount = arr2[0].length;

        int[] result = new int[columnCount];

        for (int i = 0; i < result.length; i += 1) {
            int sum = 0;

            for (int j = 0; j < arr2.length; j += 1) {
                sum += arr1[row][j] * arr2[j][i];
            }

            result[i] = sum;
        }

        return result;
    }

    public int[][] compute(int[][] arr1, int[][] arr2) {
        int[][] result = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; i += 1) {
            result[i] = computeRow(arr1, arr2, i);
        }

        return result;
    }
}
