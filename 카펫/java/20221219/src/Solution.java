import java.util.*;

class Solution {
    public void test() {
        System.out.println("heightCandidates(12): [1, 2, 3] = " + heightCandidates(12));
        System.out.println("heightCandidates(9): [1, 3] = " + heightCandidates(9));

        System.out.println("getWidthAndHeight(10, 2): {4, 3} = " + getWidthAndHeight(10, 2)[0]);
    }

    public int[] solution(int brown, int yellow) {
//        test();
        int[] answer = getWidthAndHeight(brown, yellow);
        return answer;
    }

    public List<Integer> heightCandidates(int totalGrid) {
        List<Integer> candidates = new ArrayList<>();

        for (int i = 1; i <= Math.sqrt(totalGrid); i += 1) {
            if (totalGrid % i == 0) {
                candidates.add(i);
            }
        }

        return candidates;
    }

    public int[] getWidthAndHeight(int brown, int yellow) {
        int[] answer = {};

        for (int height : heightCandidates(brown + yellow)) {
            int width = (brown + yellow) / height;

            if ((width + height - 2) * 2 == brown) {
                answer = new int[]{width, height};
                break;
            }
        }

        return answer;
    }
}
