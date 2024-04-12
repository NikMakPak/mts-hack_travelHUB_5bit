package main.tripservice.exception;

import lombok.NoArgsConstructor;
import main.tripservice.models.exception.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ExceptionControllerAdvisor {

    public ExceptionControllerAdvisor() {
    }


    @ExceptionHandler({NoSuchException.class})
    public ResponseEntity<ExceptionResponse> handleNoSuchException(NoSuchException exception){
        return new ResponseEntity(new ExceptionResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({EncryptException.class})
    public ResponseEntity<ExceptionResponse> handleEncryptException(EncryptException exception){
        return new ResponseEntity(new ExceptionResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({DecryptException.class})
    public ResponseEntity<ExceptionResponse> handleDecryptException(DecryptException exception){
        return new ResponseEntity(new ExceptionResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({AuthenticationException.class})
    public ResponseEntity<ExceptionResponse> handleAuthenticationException(AuthenticationException exception){
        return new ResponseEntity(new ExceptionResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
