// grid cell을 모두 돌면서
// 1이면 flood fill로 2로 바꾸고 count 1 up

class Solution {
    char[][] matrix;

    public int numIslands(char[][] grid) {
        int count = 0;

        matrix = grid;

        for (int i = 0; i < grid.length; i += 1) {
            for (int j = 0; j < grid[0].length; j += 1) {
                if (matrix[i][j] == '1') {
                    count += 1;
                    floodFill(i, j);
                }
            }
        }

        return count;
    }

    public void floodFill(int row, int column) {
        if (row < 0 || row > matrix.length - 1 || column < 0 || column > matrix[0].length - 1) {
            return;
        }

        if (matrix[row][column] != '1') {
            return;
        }

        if (matrix[row][column] == '2') {
            return;
        }


        matrix[row][column] = '2';

        floodFill(row - 1, column);
        floodFill(row + 1, column);
        floodFill(row, column - 1);
        floodFill(row, column + 1);
    }
}
