package main.tripservice.exception;

import lombok.NoArgsConstructor;


public class AuthenticationException extends RuntimeException{

    public AuthenticationException(String message){super(message);}

}
