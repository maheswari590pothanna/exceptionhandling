package exceptions;

import javax.swing.*;
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

    public static void validatAge(int age) throws AgeInvalidException {
        if (age < 18) {
            throw new AgeInvalidException("have patience:");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your age:");
        int age = input.nextInt();
        try {
            validatAge(age);
        } catch (AgeInvalidException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
