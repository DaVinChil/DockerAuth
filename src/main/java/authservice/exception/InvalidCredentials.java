package authservice.exception;

public class InvalidCredentials extends RuntimeException{
    public InvalidCredentials(String msg){
        super(msg);
    }
}
