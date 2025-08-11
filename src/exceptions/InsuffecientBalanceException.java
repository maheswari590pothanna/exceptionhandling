package exceptions;

import java.util.Scanner;

public class InsuffecientBalanceException extends Exception {
    private String message;

    public InsuffecientBalanceException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

class ATM {
    static void withdraw(int amount) throws InsuffecientBalanceException {
        int balance = 5000;
        if (amount < balance) {
            System.out.println("amount withdrawn successfull");
        } else {
            throw new InsuffecientBalanceException("Insuffecient balance");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the amount you want to withdraw");
        int amount = sc.nextInt();
        try {
            withdraw(amount);
        } catch (InsuffecientBalanceException e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }
}
