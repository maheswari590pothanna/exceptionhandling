package exceptions;

public class InvalidPasswordException extends RuntimeException{
    private String message;
    public InvalidPasswordException(String message){
        super(message);
    }
    @Override
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
