package exceptions;

public class Demo {
    public static void main(String[] args) {
        System.out.println("start");
        try{
            System.out.println(10/0);
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("finish");
    }
}
