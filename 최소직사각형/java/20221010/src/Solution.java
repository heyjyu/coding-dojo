import java.util.Arrays;

class Solution {
    public int solution(int[][] sizes) {
        int answer = smallestSize(sizes);
        return answer;
    }

    public int[][] sort(int[][] sizes) {
        for (int i = 0; i < sizes.length; i += 1) {
            sizes[i] = Arrays.stream(sizes[i]).sorted().toArray();
        }

        return sizes;
    }

    public int smallestSize(int[][] sizes) {
        int[][] sortedSizes = sort(sizes);

        int largestX = 0;
        int largestY = 0;

        for (int i = 0; i < sortedSizes.length; i += 1) {
            if (sortedSizes[i][0] > largestX) {
                largestX = sortedSizes[i][0];
            }

            if (sortedSizes[i][1] > largestY) {
                largestY = sortedSizes[i][1];
            }
        }

        return largestX * largestY;
    }
}
