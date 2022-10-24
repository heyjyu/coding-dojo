import java.util.*;
import java.util.stream.*;

class Solution {
    public void test() {
        System.out.println("getTheNumberOnce(new int[]{1,5,2,6,3,7,4}, new int[]{2,5,3}): " +
                getTheNumberOnce(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[]{2, 5, 3}));
        System.out.println("getAllNumbers(new int[]{1,5,2,6,3,7,4}, new int[][]{{2,5,3},{4,4,1},{1,7,3}})" +
                getAllNumbers(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}})[2]);
    }

    public int[] solution(int[] array, int[][] commands) {
        // test();
        int[] answer = getAllNumbers(array, commands);
        return answer;
    }

    public int getTheNumberOnce(int[] array, int[] command) {
        return IntStream.range(command[0] - 1, command[1])
                .map(i -> array[i])
                .sorted()
                .toArray()[command[2] - 1];
    }

    public int[] getAllNumbers(int[] array, int[][] commands) {
        return IntStream.range(0, commands.length)
                .map(i -> getTheNumberOnce(array, commands[i]))
                .toArray();
    }
}
