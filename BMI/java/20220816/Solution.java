import java.util.Scanner;

public class Solution {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("BMI 측정기");

        System.out.print("신장(m): ");

        float height = scanner.nextFloat();

        System.out.print("체중(kg): ");

        float weight = scanner.nextFloat();

        float BMI = weight / (height * height);

        System.out.print("비만도 결과: ");

        if (BMI > 25) {
            System.out.println("비만");
        }

        if (BMI > 23 && BMI <= 25) {
            System.out.println("과체중");
        }

        if (BMI > 18.5 && BMI <= 23) {
            System.out.println("정상");
        }

        if (BMI <= 18.5) {
            System.out.println("저체중");
        }

        System.out.println("BMI: " + BMI);
    }
}