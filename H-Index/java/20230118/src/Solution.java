import java.util.*;
import java.util.stream.*;

class Solution {
    public void test() {
        System.out.println("hIndex(new int[]{3, 0, 6, 1, 5}): 3 = " + hIndex(new int[]{3, 0, 6, 1, 5}));
        System.out.println("hIndex(new int[]{4, 0, 6, 1, 5}): 3 = " + hIndex(new int[]{4, 0, 6, 1, 5}));
        System.out.println("hIndex(new int[]{3, 0, 0}): 1 = " + hIndex(new int[]{3, 0, 0}));
        System.out.println("hIndex(new int[]{3, 1, 1}): 1 = " + hIndex(new int[]{3, 1, 1}));
        System.out.println("hIndex(new int[]{3, 3, 0}): 2 = " + hIndex(new int[]{3, 3, 0}));
        System.out.println("hIndex(new int[]{3, 3, 3, 0}): 3 = " + hIndex(new int[]{3, 3, 3, 0}));
    }

    public int solution(int[] citations) {
        test();
        int answer = hIndex(citations);
        return answer;
    }

    public int hIndex(int[] citations) {
        Integer[] boxedArray = Arrays.stream(citations)
                .boxed()
                .toArray(Integer[]::new);

        Arrays.sort(boxedArray, Collections.reverseOrder());

        for (int i = boxedArray[0]; i > 0; i -= 1) {
            int count = 0;

            for (int j = 0; j < boxedArray.length; j += 1) {
                if (boxedArray[j] >= i) {
                    count += 1;
                }
            }

            if (count >= i) {
                return i;
            }
        }

        return boxedArray[boxedArray.length - 1];
    }
}
