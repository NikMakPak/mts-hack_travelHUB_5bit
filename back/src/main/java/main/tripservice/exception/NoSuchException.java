package main.tripservice.exception;

import lombok.NoArgsConstructor;


public class NoSuchException extends RuntimeException{

    public NoSuchException(String message){super(message);}

}
