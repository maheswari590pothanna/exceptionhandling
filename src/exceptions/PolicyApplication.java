package exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

class PoorDrivingRecordException extends Exception {
    public PoorDrivingRecordException(String message) {
        super(message);
    }
}

class HealthIssueException extends Exception {
    public HealthIssueException(String message) {
        super(message);
    }
}

public class PolicyApplication {
    private String name;
    private int age;
    private int accidentsCount;
    private boolean hasHealthIssues;

    public PolicyApplication(String name, int age, int accidentsCount, boolean hasHealthIssues) {
        this.name = name;
        this.age = age;
        this.accidentsCount = accidentsCount;
        this.hasHealthIssues = hasHealthIssues;
    }

    public void validateAge() throws InvalidAgeException {
        if (age < 18 || age > 70) {
            throw new InvalidAgeException("Applicant age must be between 18 and 70.");
        }
    }

    public void validateDrivingHistory() throws PoorDrivingRecordException {
        if (accidentsCount > 2) {
            throw new PoorDrivingRecordException("Driving history is too poor (too many accidents).");
        }
    }

    public void validateHealthRecords() throws HealthIssueException {
        if (hasHealthIssues) {
            throw new HealthIssueException("Applicant has serious health issues.");
        }
    }

    public void processApplication() throws InvalidAgeException, PoorDrivingRecordException, HealthIssueException {
        validateAge();
        validateDrivingHistory();
        validateHealthRecords();
        System.out.println("Policy application approved for: " + name);
    }

    public static void main(String[] args) {
        PolicyApplication app1 = new PolicyApplication("Alice", 25, 1, false);
        PolicyApplication app2 = new PolicyApplication("Bob", 75, 0, false);
        PolicyApplication app3 = new PolicyApplication("Charlie", 30, 4, false);
        PolicyApplication app4 = new PolicyApplication("Daisy", 28, 0, true);

        PolicyApplication[] applications = {app1, app2, app3, app4};

        for (PolicyApplication app : applications) {
            try {
                app.processApplication();
            } catch (InvalidAgeException | PoorDrivingRecordException | HealthIssueException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}



