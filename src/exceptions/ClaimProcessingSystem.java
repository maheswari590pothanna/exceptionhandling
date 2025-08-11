package exceptions;

import java.time.LocalDate;

// ---------------- Custom Unchecked Exceptions ----------------
class FraudulentClaimException extends RuntimeException {
    public FraudulentClaimException(String message) {
        super(message);
    }
}

class InvalidClaimAmountException extends RuntimeException {
    public InvalidClaimAmountException(String message) {
        super(message);
    }
}

public class ClaimProcessingSystem {

    private String policyHolderName;
    private double coverageLimit;
    private LocalDate policyStartDate;
    private LocalDate policyEndDate;

    public ClaimProcessingSystem(String policyHolderName, double coverageLimit,
                                 LocalDate policyStartDate, LocalDate policyEndDate) {
        this.policyHolderName = policyHolderName;
        this.coverageLimit = coverageLimit;
        this.policyStartDate = policyStartDate;
        this.policyEndDate = policyEndDate;
    }

    public void processClaim(double claimAmount, LocalDate claimDate) {
        // Validate claim amount
        if (claimAmount <= 0) {
            throw new InvalidClaimAmountException("Claim amount must be greater than zero.");
        }
        if (claimAmount > coverageLimit) {
            throw new FraudulentClaimException("Claim amount exceeds coverage limit!");
        }

        // Validate claim date
        if (claimDate.isBefore(policyStartDate) || claimDate.isAfter(policyEndDate)) {
            throw new FraudulentClaimException("Claim date is outside policy coverage period!");
        }

        // If all checks pass
        System.out.println("Claim approved for " + policyHolderName + ": ₹" + claimAmount);
    }

    private static void notifyClaimsDepartment(String message) {
        System.out.println("[NOTIFICATION to Claims Department] " + message);
    }

    public static void main(String[] args) {
        ClaimProcessingSystem claim1 = new ClaimProcessingSystem(
                "Alice", 50000,
                LocalDate.of(2024, 1, 1),
                LocalDate.of(2025, 12, 31)
        );
        Object[][] claimsToProcess = {
                {claim1, 30000.0, LocalDate.of(2024, 5, 20)}, // valid
                {claim1, 60000.0, LocalDate.of(2024, 6, 15)}, // exceeds coverage
                {claim1, 25000.0, LocalDate.of(2026, 1, 10)}, // date outside coverage
                {claim1, -5000.0, LocalDate.of(2024, 7, 10)}  // invalid amount
        };

        for (Object[] claimData : claimsToProcess) {
            ClaimProcessingSystem cps = (ClaimProcessingSystem) claimData[0];
            double amount = (double) claimData[1];
            LocalDate date = (LocalDate) claimData[2];

            try {
                cps.processClaim(amount, date);
            } catch (InvalidClaimAmountException | FraudulentClaimException e) {
                System.err.println("Claim rejected for " + cps.policyHolderName + ": " + e.getMessage());
                notifyClaimsDepartment("Suspicious claim detected for " + cps.policyHolderName + ". Reason: " + e.getMessage());
            }
        }
    }
}

