import java.util.Scanner;
import java.text.DecimalFormat;

public class Solution  {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat decFormat = new DecimalFormat("###,###");

        System.out.println("적금 이자 계산기");
        System.out.println("월적립액을 입력해주세요(원):");

        int savingPerMonth = scanner.nextInt();

        System.out.println("적금 기간을 입력해주세요(년):");

        int periodInYear = scanner.nextInt();

        int periodInMonth = periodInYear * 12;

        System.out.println("연이자율을 입력해주세요(%):");

        double percentageRate = scanner.nextDouble();

        double ratePerMonth = percentageRate / 100 / 12;

        int totalSaving = savingPerMonth * periodInMonth;

        System.out.println("원금합계: " + decFormat.format(totalSaving) + "원");

        int preTaxTotalAmount = (int)Math.ceil(savingPerMonth * (1 + ratePerMonth) * (Math.pow((1 + ratePerMonth), periodInMonth) - 1) / ratePerMonth);

        int preTaxInterest = preTaxTotalAmount - totalSaving;

        double taxRate = 15.4 * 0.01;

        int interest = (int)(preTaxInterest * (1 - taxRate));

        System.out.println("세후이자: " + decFormat.format(interest) + "원");

        int totalValue = totalSaving + interest;

        System.out.println("세후 총 수령액: " + decFormat.format(totalValue) + "원");
    }
}
