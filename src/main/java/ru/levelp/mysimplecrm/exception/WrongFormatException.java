package ru.levelp.mysimplecrm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WrongFormatException extends RuntimeException{

    public WrongFormatException(){
        super("Введите число!");
    }

}
