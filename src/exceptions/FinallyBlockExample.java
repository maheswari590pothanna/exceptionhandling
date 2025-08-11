package exceptions;

public class FinallyBlockExample {
    public static void main(String[] args) {
        System.out.println("start");

        try {
            System.out.println("10/0");
        } catch (ArithmeticException e) {
            System.out.println("Invalid denominator:");
        } finally {
            System.out.println("Invalid finally block:");
        }
        System.out.println("end");
    }
}
