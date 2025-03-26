import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class LoanAmortization {

    // Constant Loan Details from closing
    private static final double LOAN_AMOUNT_AT_CLOSING = 542617;
    private static final int LOAN_TERM_YEARS = 30;
    private static final double INTEREST_RATE_AT_CLOSING = 3.875;
    private static final LocalDate LOAN_START_DATE = LocalDate.parse("2022-08-31");
    private static final double CURRENT_UNPAID_PRINCIPAL = 509511.31;
    private static final double ESCROW_CURRENT = 591.11;
    // Provided constants (as per your numbers)
    private static final double BASE_PANDI_MONTHLY = 2551.59; // Principal & Interest (Monthly)
    private static final double BASE_TOTAL_MONTHLY = BASE_PANDI_MONTHLY + ESCROW_CURRENT; // 3142.70
    private static final double BASE_BIWEEKLY_EXCL = BASE_PANDI_MONTHLY / 2; // 1275.80
    private static final double BASE_BIWEEKLY_INCL = BASE_TOTAL_MONTHLY / 2;  // 1571.35
    // Constant extra biweekly amounts for simulation
    private static final double[] EXTRA_BIWEEKLY_CONSTANTS = {0, 28.65, 50, 100, 150, 200, 250};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display constant loan details
        System.out.println("=== LOAN DETAILS (Constants) ===");
        System.out.printf("Loan Amount at Closing: $%,.2f%n", LOAN_AMOUNT_AT_CLOSING);
        System.out.printf("Total Loan Term at Closing: %d years%n", LOAN_TERM_YEARS);
        System.out.printf("Interest Rate at Closing (Annual %%): %.3f%n", INTEREST_RATE_AT_CLOSING);
        System.out.printf("Loan Start Date: %s%n", LOAN_START_DATE);
        System.out.printf("Current Unpaid Principal: $%,.2f%n", CURRENT_UNPAID_PRINCIPAL);
        System.out.printf("Current Escrow: $%,.2f%n", ESCROW_CURRENT);

        LocalDate currentDate = LocalDate.now();
        long monthsPassed = ChronoUnit.MONTHS.between(LOAN_START_DATE, currentDate);
        System.out.println("\nMonths since loan started: " + monthsPassed);

        // Calculate scheduled balance using amortization (for consistency checking)
        double scheduledBalance = calculateScheduledBalance(LOAN_AMOUNT_AT_CLOSING, INTEREST_RATE_AT_CLOSING, LOAN_TERM_YEARS, (int) monthsPassed);

        // Validate principal consistency
        if (CURRENT_UNPAID_PRINCIPAL < scheduledBalance) {
            double extraPaid = scheduledBalance - CURRENT_UNPAID_PRINCIPAL;
            System.out.printf("\n⚠️  Extra Principal Detected: $%,.2f paid beyond schedule%n", extraPaid);
        } else if (CURRENT_UNPAID_PRINCIPAL > scheduledBalance) {
            System.out.println("\n⚠️  Warning: Your principal is higher than scheduled - check for missed payments");
        }

        // Extra payment details (for current scenario)
        System.out.print("\nEnter Extra Principal Payment Biweekly: ");
        double extraPrincipalBiweekly = scanner.nextDouble();
        double extraPrincipalMonthly = extraPrincipalBiweekly * 26 / 12; // Convert biweekly to monthly

        // Escrow is always included (no prompt needed)
        double escrowAmount = ESCROW_CURRENT;

        // Use provided constant EMI values for simulation (no refinance option at this stage)
        int remainingTermYears = LOAN_TERM_YEARS - (int) (monthsPassed / 12);
        double currentMonthlyPayment = BASE_PANDI_MONTHLY;  // Without refinance, EMI remains as provided

        // Calculate amortization for overall scenarios:
        // Original schedule (without extra payments)
        AmortizationResult originalSchedule = calculateAmortization(LOAN_AMOUNT_AT_CLOSING, INTEREST_RATE_AT_CLOSING, LOAN_TERM_YEARS, 0);
        // Current scenario: using current unpaid principal with extra payments (no refinance)
        AmortizationResult currentSchedule = calculateAmortization(CURRENT_UNPAID_PRINCIPAL, INTEREST_RATE_AT_CLOSING, remainingTermYears, extraPrincipalMonthly);

        // Calculate extra principal paid till now
        double scheduledPrincipalPaid = LOAN_AMOUNT_AT_CLOSING - scheduledBalance;
        double actualPrincipalPaid = LOAN_AMOUNT_AT_CLOSING - CURRENT_UNPAID_PRINCIPAL;
        double extraPaidTillNow = actualPrincipalPaid - scheduledPrincipalPaid;

        // Base payments for simulation (using provided constants)
        double baseMonthlyEMI = BASE_PANDI_MONTHLY; // 2551.59
        double baseBiweeklyExcl = BASE_BIWEEKLY_EXCL; // 1275.80
        double baseBiweeklyIncl = BASE_BIWEEKLY_INCL;  // 1571.35
        double baseTotalMonthly = BASE_TOTAL_MONTHLY;  // 3142.70

        // Remaining Loan Term Calculations:
        int totalMonths = LOAN_TERM_YEARS * 12;
        int scheduledRemainingMonths = totalMonths - (int) monthsPassed;
        int scheduledRemainingYears = scheduledRemainingMonths / 12;
        int scheduledRemainingMonthsOnly = scheduledRemainingMonths % 12;
        LocalDate scheduledMaturityDate = LOAN_START_DATE.plusMonths(totalMonths);

        // For overall summary, projected term from current scenario:
        int projectedTotalMonths = currentSchedule.months;
        int projectedRemainingMonths = projectedTotalMonths - (int) monthsPassed;
        int projectedRemainingYears = projectedRemainingMonths / 12;
        int projectedRemainingMonthsOnly = projectedRemainingMonths % 12;
        LocalDate projectedMaturityDate = LOAN_START_DATE.plusMonths(projectedTotalMonths);

        // paymentsMadeOriginal represents the number of monthly payments made so far.
        int paymentsMadeOriginal = (int) monthsPassed;

        // Display overall loan payoff summary
        System.out.println("\n=== LOAN PAYOFF SUMMARY ===");
        System.out.println("---------------------------------------------");
        System.out.printf("%-40s%,12.2f%n", "Original Loan Amount:", LOAN_AMOUNT_AT_CLOSING);
        System.out.printf("%-40s%,12.2f%n", "Current Principal Balance:", CURRENT_UNPAID_PRINCIPAL);
        System.out.printf("%-40s%,12.2f%n", "Scheduled Balance (no extras):", scheduledBalance);
        System.out.println("---------------------------------------------");
        System.out.printf("%-40s%,12.2f%n", "Original Monthly Payment (P&I):", currentMonthlyPayment);
        System.out.printf("%-40s%,12.2f%n", "Current Monthly Payment (P&I):", currentMonthlyPayment);
        System.out.printf("%-40s%,12.2f%n", "+ Monthly Escrow:", escrowAmount);
        System.out.printf("%-40s%,12.2f%n", "= Total Monthly Payment:", currentMonthlyPayment + escrowAmount);
        System.out.println("---------------------------------------------");
        System.out.printf("%-40s%,12.2f%n", "Total Interest (Original):", originalSchedule.totalInterest);
        System.out.printf("%-40s%,12.2f%n", "Total Interest (Current):", currentSchedule.totalInterest);
        System.out.printf("%-40s%,12.2f%n", "Interest Saved:", originalSchedule.totalInterest - currentSchedule.totalInterest);
        System.out.println("---------------------------------------------");
        System.out.printf("%-40s%12d%n", "Original Loan Term (months):", totalMonths);
        System.out.printf("%-40s%12d%n", "Projected Term (Current):", projectedTotalMonths);
        System.out.printf("%-40s%12d%n", "Months Saved:", totalMonths - projectedTotalMonths);
        System.out.println("---------------------------------------------");
        System.out.printf("%-40s%,12.2f%n", "Total Extra Principal Paid:", extraPaidTillNow);
        System.out.printf("%-40s%,12.2f%n", "Projected Extra Payments:", extraPrincipalMonthly * currentSchedule.months);
        System.out.println("---------------------------------------------");
        System.out.printf("%-40s%12d%n", "Scheduled Remaining Term (months):", scheduledRemainingMonths);
        System.out.printf("%-40s%s%n", "Which is:", scheduledRemainingYears + " years, " + scheduledRemainingMonthsOnly + " months");
        System.out.printf("%-40s%12d%n", "Projected Remaining Term (months):", projectedRemainingMonths);
        System.out.printf("%-40s%s%n", "Which is (with extras):", projectedRemainingYears + " years, " + projectedRemainingMonthsOnly + " months");
        System.out.println("---------------------------------------------");
        System.out.printf("%-40s%s%n", "Scheduled Maturity Date:", scheduledMaturityDate.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy")));
        System.out.printf("%-40s%s%n", "Projected Maturity Date:", projectedMaturityDate.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy")));
        System.out.println("---------------------------------------------");
        System.out.printf("%-40s%,12.2f%n", "Total Principal Paid (Original):", LOAN_AMOUNT_AT_CLOSING - scheduledBalance);
        System.out.printf("%-40s%,12.2f%n", "Total Principal Paid (Current):", LOAN_AMOUNT_AT_CLOSING - CURRENT_UNPAID_PRINCIPAL);
        System.out.printf("%-40s%12d%n", "Payments Made (months):", paymentsMadeOriginal);
        System.out.println("---------------------------------------------");

        // Simulation table for extra biweekly payments using constant array
        System.out.println("\n=== SIMULATION OF EXTRA Biweekly PAYMENTS ===");
        System.out.printf("%-20s %-20s %-25s %-25s %-25s %-30s %-20s %-25s %-25s %-20s%n",
                "Extra Biweekly", "Extra Monthly", "Biweekly Payment (Total)", "Biweekly Payment (Incl. Escrow)",
                "Monthly Total Payment", "Projected Term (months)", "Term (yr,mo)",
                "Maturity Date", "Total Interest (Current)", "Interest Saved");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        for (double extraBiweeklyScenario : EXTRA_BIWEEKLY_CONSTANTS) {
            double extraMonthlyScenario = extraBiweeklyScenario * 26 / 12;
            // Effective biweekly payments:
            double effectiveBiweeklyExcl = baseBiweeklyExcl + extraBiweeklyScenario;
            double effectiveBiweeklyIncl = baseBiweeklyIncl + extraBiweeklyScenario;
            // Monthly Total Payment = base monthly P&I + extra monthly + escrow
            double effectiveMonthlyTotal = baseMonthlyEMI + extraMonthlyScenario + escrowAmount;
            // For simulation, use amortization on current unpaid principal with extraMonthlyScenario
            AmortizationResult scenario = calculateAmortization(CURRENT_UNPAID_PRINCIPAL, INTEREST_RATE_AT_CLOSING,
                    remainingTermYears, extraMonthlyScenario);
            int projectedTermMonths = scenario.months;
            int remainingScenarioMonths = projectedTermMonths - (int) monthsPassed;
            if (remainingScenarioMonths < 0) remainingScenarioMonths = 0;
            int scenarioYears = remainingScenarioMonths / 12;
            int scenarioMonths = remainingScenarioMonths % 12;
            LocalDate scenarioMaturityDate = LOAN_START_DATE.plusMonths(projectedTermMonths);
            double scenarioInterest = scenario.totalInterest;
            double interestSaved = originalSchedule.totalInterest - scenarioInterest;
            System.out.printf("%-20.2f %-20.2f %-25.2f %-25.2f %-25.2f %-30d %-20s %-25s %-25.2f %-20.2f%n",
                    extraBiweeklyScenario,
                    extraMonthlyScenario,
                    effectiveBiweeklyExcl,
                    effectiveBiweeklyIncl,
                    effectiveMonthlyTotal,
                    projectedTermMonths,
                    scenarioYears + "y " + scenarioMonths + "m",
                    scenarioMaturityDate.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy")),
                    scenarioInterest,
                    interestSaved);
        }

        // Refinance simulation
        System.out.print("\nDo you want to simulate a refinance scenario? (Enter new interest rate or 0 to skip): ");
        double refinanceInterestRate = scanner.nextDouble();
        if (refinanceInterestRate > 0) {
            System.out.print("Enter new loan term in years for refinance: ");
            int refinanceTermYears = scanner.nextInt();
            AmortizationResult refinanceScenario = calculateAmortization(CURRENT_UNPAID_PRINCIPAL, refinanceInterestRate, refinanceTermYears, extraPrincipalMonthly);
            int refinanceTotalMonths = refinanceScenario.months;
            int refinanceRemainingMonths = refinanceTotalMonths - (int) monthsPassed;
            if (refinanceRemainingMonths < 0) refinanceRemainingMonths = 0;
            int refinanceYears = refinanceRemainingMonths / 12;
            int refinanceMonths = refinanceRemainingMonths % 12;
            double refinanceEMI = calculateMonthlyPayment(CURRENT_UNPAID_PRINCIPAL, refinanceInterestRate, refinanceTermYears);
            double refinanceBiweeklyExcl = refinanceEMI / 2;
            double refinanceBiweeklyIncl = (refinanceEMI + escrowAmount) / 2;
            double refinanceTotalMonthly = refinanceEMI + extraPrincipalMonthly + escrowAmount;
            LocalDate refinanceMaturityDate = LOAN_START_DATE.plusMonths(refinanceTotalMonths);
            double refinanceInterest = refinanceScenario.totalInterest;
            double refinanceInterestSaved = originalSchedule.totalInterest - refinanceInterest;
            // Print refinance simulation row with an asterisk
            System.out.printf("%-20s %-20s %-25.2f %-25.2f %-25.2f %-30d %-20s %-25s %-25.2f %-20.2f%n",
                    "*Refinance", "*", refinanceBiweeklyExcl, refinanceBiweeklyIncl,
                    refinanceTotalMonthly, refinanceTotalMonths,
                    refinanceYears + "y " + refinanceMonths + "m",
                    refinanceMaturityDate.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy")),
                    refinanceInterest,
                    refinanceInterestSaved);

            // Detailed refinance summary
            int totalOriginalMonths = LOAN_TERM_YEARS * 12;
            int refinanceRemainingTotal = refinanceTotalMonths - (int) monthsPassed;
            int refinanceRemainingYears = refinanceRemainingTotal / 12;
            int refinanceRemainingMonthsOnly = refinanceRemainingTotal % 12;
            LocalDate refinanceScheduledMaturity = LOAN_START_DATE.plusMonths(totalOriginalMonths);
            LocalDate refinanceProjectedMaturity = LOAN_START_DATE.plusMonths(refinanceTotalMonths);
            double refinancePrincipalPaidOriginal = LOAN_AMOUNT_AT_CLOSING - scheduledBalance;
            double refinancePrincipalPaidCurrent = LOAN_AMOUNT_AT_CLOSING - CURRENT_UNPAID_PRINCIPAL;

            System.out.println("\n=== REFINANCE PAYOFF SUMMARY ===");
            System.out.println("---------------------------------------------");
            System.out.printf("%-40s%,12.2f%n", "Original Loan Amount:", LOAN_AMOUNT_AT_CLOSING);
            System.out.printf("%-40s%,12.2f%n", "Current Principal Balance:", CURRENT_UNPAID_PRINCIPAL);
            System.out.printf("%-40s%,12.2f%n", "Scheduled Balance (no extras):", scheduledBalance);
            System.out.println("---------------------------------------------");
            System.out.printf("%-40s%,12.2f%n", "Refinance Monthly Payment (P&I):", refinanceEMI);
            System.out.printf("%-40s%,12.2f%n", "+ Monthly Escrow:", escrowAmount);
            System.out.printf("%-40s%,12.2f%n", "= Total Monthly Payment:", refinanceEMI + escrowAmount);
            System.out.println("---------------------------------------------");
            System.out.printf("%-40s%,12.2f%n", "Total Interest (Original):", originalSchedule.totalInterest);
            System.out.printf("%-40s%,12.2f%n", "Total Interest (Refinance):", refinanceInterest);
            System.out.printf("%-40s%,12.2f%n", "Interest Saved:", originalSchedule.totalInterest - refinanceInterest);
            System.out.println("---------------------------------------------");
            System.out.printf("%-40s%12d%n", "Original Loan Term (months):", totalOriginalMonths);
            System.out.printf("%-40s%12d%n", "Projected Term (Refinance):", refinanceTotalMonths);
            System.out.printf("%-40s%12d%n", "Months Saved:", totalOriginalMonths - refinanceTotalMonths);
            System.out.println("---------------------------------------------");
            System.out.printf("%-40s%,12.2f%n", "Total Extra Principal Paid:", refinancePrincipalPaidOriginal);
            System.out.printf("%-40s%,12.2f%n", "Total Principal Paid (Refinance):", refinancePrincipalPaidCurrent);
            System.out.printf("%-40s%12d%n", "Payments Made (months):", (int) monthsPassed);
            System.out.println("---------------------------------------------");
            System.out.printf("%-40s%12d%n", "Scheduled Remaining Term (months):", scheduledRemainingMonths);
            System.out.printf("%-40s%s%n", "Which is:", scheduledRemainingYears + " years, " + scheduledRemainingMonthsOnly + " months");
            System.out.printf("%-40s%12d%n", "Projected Remaining Term (months):", refinanceRemainingTotal);
            System.out.printf("%-40s%s%n", "Which is (with extras):", refinanceRemainingYears + " years, " + refinanceRemainingMonthsOnly + " months");
            System.out.println("---------------------------------------------");
            System.out.printf("%-40s%s%n", "Scheduled Maturity Date:", refinanceScheduledMaturity.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy")));
            System.out.printf("%-40s%s%n", "Projected Maturity Date:", refinanceProjectedMaturity.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy")));
            System.out.println("---------------------------------------------");
            System.out.printf("%-40s%,12.2f%n", "Total Principal Paid (Original):", refinancePrincipalPaidOriginal);
            System.out.printf("%-40s%,12.2f%n", "Total Principal Paid (Refinance):", refinancePrincipalPaidCurrent);
            System.out.printf("%-40s%12d%n", "Payments Made (months):", (int) monthsPassed);
            System.out.println("---------------------------------------------");
        }

        scanner.close();
    }

    // Helper class to store amortization results
    private static class AmortizationResult {
        double totalInterest;
        int months;

        AmortizationResult(double totalInterest, int months) {
            this.totalInterest = totalInterest;
            this.months = months;
        }
    }

    // Calculate amortization details given principal, annual rate, term in years, and extra monthly payment
    private static AmortizationResult calculateAmortization(double principal, double annualRate, int termYears, double extraPayment) {
        double monthlyRate = (annualRate / 100) / 12;
        double monthlyPayment = calculateMonthlyPayment(principal, annualRate, termYears);
        double remainingPrincipal = principal;
        double totalInterest = 0;
        int months = 0;
        while (remainingPrincipal > 0 && months < termYears * 12) {
            double interest = remainingPrincipal * monthlyRate;
            double principalPaid = monthlyPayment - interest + extraPayment;
            if (principalPaid > remainingPrincipal) {
                principalPaid = remainingPrincipal;
            }
            totalInterest += interest;
            remainingPrincipal -= principalPaid;
            months++;
        }
        return new AmortizationResult(totalInterest, months);
    }

    // Calculate monthly payment given principal, annual rate, and term in years
    private static double calculateMonthlyPayment(double principal, double annualRate, double termYears) {
        double monthlyRate = (annualRate / 100) / 12;
        int totalMonths = (int) Math.round(termYears * 12);
        return (principal * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -totalMonths));
    }

    // Calculate scheduled balance after a given number of months without extra payments
    private static double calculateScheduledBalance(double principal, double annualRate, int loanTermYears, int monthsPassed) {
        double monthlyRate = (annualRate / 100) / 12;
        double monthlyPayment = calculateMonthlyPayment(principal, annualRate, loanTermYears);
        double balance = principal;
        for (int i = 0; i < monthsPassed; i++) {
            double interest = balance * monthlyRate;
            double principalPaid = monthlyPayment - interest;
            balance -= principalPaid;
        }
        return balance;
    }
}
