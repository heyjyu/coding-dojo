import java.util.*;

class Solution {
    public void test() {
        int[][] board = new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = new int[]{1,5,3,5,1,2,1,4};

        System.out.println("process(board, moves): 4 = " + process(board, moves));

        board = new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        moves = new int[]{1,4,1,4};

        System.out.println("process(board, moves): 4 = " + process(board, moves));
    }

    public int solution(int[][] board, int[] moves) {
        // test();
        int answer = process(board, moves);
        return answer;
    }

    public int process(int[][] board, int[] moves) {
        List<Integer> bag = new ArrayList<>();
        int count = 0;

        for (int i : moves) {
            for (int j = 0; j < board.length; j += 1) {
                int value = board[j][i - 1];

                if (value > 0) {
                    board[j][i - 1] = 0;

                    if (bag.size() > 0 && bag.get(bag.size() - 1) == value) {
                        bag.remove(bag.size() - 1);

                        count += 2;

                        break;
                    }

                    bag.add(value);

                    break;
                }
            }
        }

        return count;
    }
}
