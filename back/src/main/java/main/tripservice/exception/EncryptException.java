package main.tripservice.exception;

import lombok.NoArgsConstructor;


public class EncryptException extends RuntimeException{

    public EncryptException(String message){super(message);}

}
