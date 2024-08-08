import java.util.Scanner;

public class MortgageCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input loan amount
        System.out.print("Enter the loan amount: $");
        double loanAmount = scanner.nextDouble();

        // Input annual interest rate
        System.out.print("Enter the annual interest rate (in percentage): ");
        double annualInterestRate = scanner.nextDouble();

        // Input loan term in years
        System.out.print("Enter the loan term (in years): ");
        int loanTermYears = scanner.nextInt();

        // Convert annual interest rate to monthly and loan term to months
        double monthlyInterestRate = annualInterestRate / 100 / 12;
        int loanTermMonths = loanTermYears * 12;

        // Calculate monthly mortgage payment
        double monthlyPayment = calculateMonthlyPayment(loanAmount, monthlyInterestRate, loanTermMonths);

        // Display result
        System.out.printf("Your monthly mortgage payment is: $%.2f%n", monthlyPayment);
    }

    /**
     * Calculates the monthly mortgage payment using the formula:
     * M = P[r(1 + r)^n] / [(1 + r)^n – 1]
     * where:
     * M = monthly payment
     * P = principal loan amount
     * r = monthly interest rate
     * n = number of payments (months)
     */
    private static double calculateMonthlyPayment(double principal, double monthlyRate, int numberOfPayments) {
        if (monthlyRate == 0) {
            return principal / numberOfPayments;
        }

        double numerator = monthlyRate * Math.pow(1 + monthlyRate, numberOfPayments);
        double denominator = Math.pow(1 + monthlyRate, numberOfPayments) - 1;
        return principal * (numerator / denominator);
    }
}
