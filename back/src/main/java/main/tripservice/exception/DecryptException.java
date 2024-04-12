package main.tripservice.exception;

import lombok.NoArgsConstructor;


public class DecryptException extends RuntimeException{

    public DecryptException(String message){super(message);}

}
