package exceptions;

import java.util.Scanner;

public class ExceptionHierarchy {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter the choice");
        try {
            int choice = input.nextInt();
            if (choice == 1) {
                int result = 10 / 0;
                System.out.println(result);
            } else if (choice == 2) {

                String str = null;
                System.out.println(str.length());
            } else {
                int[] arr = {1, 2, 3};
                System.out.println(arr[4]);
            }
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("program execution continues..");
    }
}
