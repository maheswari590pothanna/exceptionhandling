package exceptions;

import java.util.Scanner;

public class NegativeNumberException extends RuntimeException {
    private String message;

    public NegativeNumberException(String message) {
        super(message);
    }

    public String getMessage() {
        return message;
    }

    public static void find(int num) throws NegativeNumberException {
        int i = 12;
        if (num > 0) {
            System.out.println(" divisible value of " + num + "is" + i / num);

        }
        else{
            throw new NegativeNumberException("negative number.enter positive value");
        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter the number");
        int number = input.nextInt();
        try {
            find(number);
        } catch (NegativeNumberException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
