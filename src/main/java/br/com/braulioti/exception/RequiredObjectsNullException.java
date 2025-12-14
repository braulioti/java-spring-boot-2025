package br.com.braulioti.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequiredObjectsNullException extends RuntimeException {


    public RequiredObjectsNullException() {
        super("It is not allowed to persist a null object!");
    }

    public RequiredObjectsNullException(String message) {
        super(message);
    }
}
