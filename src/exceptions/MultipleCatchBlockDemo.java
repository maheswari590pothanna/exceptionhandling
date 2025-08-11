package exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MultipleCatchBlockDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("enter the first number:");
            int num1 = sc.nextInt();
            System.out.println("enter the second number:");
            int num2 = sc.nextInt();
            int result = num1 / num2;

        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
