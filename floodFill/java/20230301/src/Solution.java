class Solution {
    int originalColor;
    int[][] filledImage;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        originalColor = image[sr][sc];
        filledImage = image;

        fill(filledImage, sr, sc, color);

        return filledImage;
    }

    public void fill(int[][] image, int sr, int sc, int color) {
        if (sr < 0 || sc < 0 || sr > image.length - 1 || sc > image[0].length - 1) {
            return;
        }

        if (image[sr][sc] != originalColor) {
            return;
        }

        if (image[sr][sc] == color) {
            return;
        }

        image[sr][sc] = color;

        fill(image, sr - 1, sc, color);
        fill(image, sr, sc - 1, color);
        fill(image, sr + 1, sc, color);
        fill(image, sr, sc + 1, color);
    }
}
