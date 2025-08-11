package exceptions;

import java.util.Scanner;

public class GMailLogin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the password");
        int password = sc.nextInt();
        sc.close();
        if (password == 123) {
            System.out.println("login successful");

        } else {
            try {
                throw new InvalidPasswordException("Invalid Password");
            } catch (InvalidPasswordException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
