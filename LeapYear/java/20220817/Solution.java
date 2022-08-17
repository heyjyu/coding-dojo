import java.util.Scanner;

public class Solution {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("연도: ");

        int year = scanner.nextInt();

        if (year % 4 == 0) {
            if (year % 100 == 0 && year % 400 != 0) {
                System.out.println(false);
            }

            if (year % 400 == 0) {
                System.out.println(true);
            }

            if (year % 100 != 0) {
                System.out.println(true);
            }
        }

        if (year % 4 != 0) {
            System.out.println(false);
        }
    }
}
