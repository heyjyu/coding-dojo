import java.util.Scanner;

public class Solution {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("급할 때 사용하는 일회용 계산기");

        System.out.println("숫자를 입력해 주세요:");

        double number1 = scanner.nextDouble();

        System.out.println("연산자를 선택해주세요:");
        System.out.println("1. + (더하기)");
        System.out.println("2. - (빼기)");
        System.out.println("3. * (곱하기)");
        System.out.println("4. / (나누기)");

        int operatorIndex = scanner.nextInt();

        System.out.println("숫자를 입력해 주세요:");

        double number2 = scanner.nextDouble();

        if (operatorIndex == 1) {
            double result = number1 + number2;

            System.out.println("계산 결과: " + result);
        }

        if (operatorIndex == 2) {
            double result = number1 - number2;

            System.out.println("계산 결과: " + result);
        }

        if (operatorIndex == 3) {
            double result = number1 * number2;

            System.out.println("계산 결과: " + result);
        }

        if (operatorIndex == 4) {
            double result = number1 / number2;

            System.out.println("계산 결과: " + result);
        }
    }
}