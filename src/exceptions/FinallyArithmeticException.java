package exceptions;

import java.util.Scanner;

public class FinallyArithmeticException {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter the number");
        int den=input.nextInt();
        try{
            System.out.println(100/den);
        }catch(ArithmeticException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }finally{
            input.close();
        }
    }
}
