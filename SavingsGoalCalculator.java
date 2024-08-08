import java.util.Scanner;

public class SavingsGoalCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your savings goal amount: $");
        double savingsGoal = scanner.nextDouble();

        System.out.print("Enter the time frame to reach your goal (in years): ");
        int timeFrameYears = scanner.nextInt();

        System.out.print("Enter the expected annual rate of return (in percentage): ");
        double annualRateOfReturn = scanner.nextDouble();

        double annualRateDecimal = annualRateOfReturn / 100;

        int timeFrameMonths = timeFrameYears * 12;

        double monthlyInvestment = calculateMonthlyInvestment(savingsGoal, annualRateDecimal, timeFrameMonths);

        System.out.printf("You need to invest $%.2f per month to reach your goal.%n", monthlyInvestment);
    }
    private static double calculateMonthlyInvestment(double futureValue, double annualRate, int numberOfMonths) {
        if (annualRate == 0) {
            return futureValue / numberOfMonths;
        }

        double monthlyRate = annualRate / 12;
        double numerator = monthlyRate * Math.pow(1 + monthlyRate, numberOfMonths);
        double denominator = Math.pow(1 + monthlyRate, numberOfMonths) - 1;
        return futureValue * (numerator / denominator);
    }
}
