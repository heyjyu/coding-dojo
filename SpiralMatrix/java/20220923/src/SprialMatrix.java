import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SprialMatrix {
    private int length;

    public static void main(String[] args) {
        SprialMatrix application = new SprialMatrix();

        application.run();
    }

    private void run() {
        inputLength();

        printArray();
    }

    private void inputLength() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("배열의 한변 길이: ");

        length = scanner.nextInt();
    }

    private int[][] process() {
        int[] position = {0, 0};
        int[] direction = {1, 0};
        int[][] matrix = matrix(length);

        step(length, matrix, position, direction, 0);

        return matrix;
    }

    private void step(int length, int[][] matrix, int[] position, int[] direction, int number) {
        if (number > length * length) {
            return;
        }

        int x = position[0];
        int y = position[1];

        matrix[y][x] = number;

        boolean blocked = isBlock(length, matrix, x + direction[0], y + direction[1]);

        int[] newDirection = !blocked ? direction : new int[]{-direction[1], direction[0]};

        step(length, matrix, new int[]{x + newDirection[0], y + newDirection[1]}, newDirection, number + 1);
    }

    public boolean isBlock(int length, int[][] matrix, int x, int y) {
        return x < 0 || x >= length || y < 0 || y >= length || matrix[y][x] >= 0;
    }

    private void printArray() {
        System.out.println("나선형 배열:");

        int[][] matrix = process();

        for (int i = 0; i < length; i += 1) {
            for (int j = 0; j < length; j += 1) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public int[][] matrix(int length) {
        int[][] matrix = new int[length][length];

        for (int i = 0; i < length; i += 1) {
            for (int j = 0; j < length; j += 1) {
                matrix[i][j] = -1;
            }
        }

        return matrix;
    }
}
