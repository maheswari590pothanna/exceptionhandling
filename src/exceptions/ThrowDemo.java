package exceptions;

public class ThrowDemo {
    static void display() throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
            Thread.sleep(1000);
        }
    }

    public static void main(String[] args) {
        System.out.println("start");
        try {
            display();
        } catch (InterruptedException e) {
            System.out.println("handled");
        }
        System.out.println("finish");
    }
}

