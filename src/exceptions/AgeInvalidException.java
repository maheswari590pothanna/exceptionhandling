package exceptions;

import java.util.Scanner;

public class AgeInvalidException extends Exception {
    private String message;

    public AgeInvalidException(String message) {
        this.message = message;

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        if (age > 21) {
            System.out.println("get married! hopefully stay happy");
        } else {
            try {
                throw new AgeInvalidException("have patience");
            } catch (AgeInvalidException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
