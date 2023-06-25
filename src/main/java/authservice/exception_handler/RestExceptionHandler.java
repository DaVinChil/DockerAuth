package authservice.exception_handler;

import authservice.exception.InvalidCredentials;
import authservice.exception.UnauthorizedUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> invalidCredentialHandler(InvalidCredentials ice){
        return new ResponseEntity<>(ice.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> unauthorizedUserHandler(UnauthorizedUser uue){
        return new ResponseEntity<>(uue.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
