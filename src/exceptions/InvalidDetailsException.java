package exceptions;

public class InvalidDetailsException extends RuntimeException {
    private String message;

    public InvalidDetailsException(String message) {
        super(message);
    }


}
