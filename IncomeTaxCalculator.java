import java.util.Scanner;

public class IncomeTaxCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input annual income
        System.out.print("Enter your annual income: $");
        double annualIncome = scanner.nextDouble();

        // Input deductions
        System.out.print("Enter your total deductions: $");
        double deductions = scanner.nextDouble();

        // Input tax credits
        System.out.print("Enter your total tax credits: $");
        double taxCredits = scanner.nextDouble();

        // Input filing status
        System.out.print("Enter your filing status (single/married): ");
        String filingStatus = scanner.next().toLowerCase();

        // Calculate taxable income
        double taxableIncome = annualIncome - deductions;

        // Calculate tax liability based on filing status
        double taxLiability = calculateTaxLiability(taxableIncome, filingStatus);

        // Apply tax credits
        double finalTaxLiability = Math.max(0, taxLiability - taxCredits);

        // Display results
        System.out.printf("Your estimated tax liability is: $%.2f%n", finalTaxLiability);
    }

    /**
     * Calculates tax liability based on taxable income and filing status.
     * Uses a simplified tax bracket system for illustration.
     */
    private static double calculateTaxLiability(double taxableIncome, String filingStatus) {
        double tax = 0;

        // Define tax brackets and rates (example brackets)
        if (filingStatus.equals("single")) {
            if (taxableIncome <= 9950) {
                tax = taxableIncome * 0.10;
            } else if (taxableIncome <= 40525) {
                tax = 9950 * 0.10 + (taxableIncome - 9950) * 0.12;
            } else if (taxableIncome <= 86375) {
                tax = 9950 * 0.10 + (40525 - 9950) * 0.12 + (taxableIncome - 40525) * 0.22;
            } else if (taxableIncome <= 164925) {
                tax = 9950 * 0.10 + (40525 - 9950) * 0.12 + (86375 - 40525) * 0.22 + (taxableIncome - 86375) * 0.24;
            } else {
                tax = 9950 * 0.10 + (40525 - 9950) * 0.12 + (86375 - 40525) * 0.22 + (164925 - 86375) * 0.24 + (taxableIncome - 164925) * 0.32;
            }
        } else if (filingStatus.equals("married")) {
            if (taxableIncome <= 19900) {
                tax = taxableIncome * 0.10;
            } else if (taxableIncome <= 81050) {
                tax = 19900 * 0.10 + (taxableIncome - 19900) * 0.12;
            } else if (taxableIncome <= 172750) {
                tax = 19900 * 0.10 + (81050 - 19900) * 0.12 + (taxableIncome - 81050) * 0.22;
            } else if (taxableIncome <= 329850) {
                tax = 19900 * 0.10 + (81050 - 19900) * 0.12 + (172750 - 81050) * 0.22 + (taxableIncome - 172750) * 0.24;
            } else {
                tax = 19900 * 0.10 + (81050 - 19900) * 0.12 + (172750 - 81050) * 0.22 + (329850 - 172750) * 0.24 + (taxableIncome - 329850) * 0.32;
            }
        } else {
            System.out.println("Invalid filing status.");
        }

        return tax;
    }
}
