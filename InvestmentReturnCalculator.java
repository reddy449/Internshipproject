import java.util.Scanner;

public class InvestmentReturnCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input initial investment amount
        System.out.print("Enter the initial investment amount: $");
        double initialInvestment = scanner.nextDouble();

        // Input annual rate of return
        System.out.print("Enter the expected annual rate of return (in percentage): ");
        double annualRateOfReturn = scanner.nextDouble();

        // Input investment time horizon in years
        System.out.print("Enter the investment time horizon (in years): ");
        int investmentHorizonYears = scanner.nextInt();

        // Convert annual rate of return to a decimal
        double annualRateDecimal = annualRateOfReturn / 100;

        // Calculate future value of the investment
        double futureValue = calculateFutureValue(initialInvestment, annualRateDecimal, investmentHorizonYears);

        // Display result
        System.out.printf("The future value of the investment is: $%.2f%n", futureValue);
    }

    /**
     * Calculates the future value of an investment using the formula:
     * FV = P * (1 + r)^n
     * where:
     * FV = future value of the investment
     * P = principal investment amount
     * r = annual rate of return (decimal)
     * n = number of years
     */
    private static double calculateFutureValue(double principal, double annualRate, int years) {
        return principal * Math.pow(1 + annualRate, years);
    }
}
