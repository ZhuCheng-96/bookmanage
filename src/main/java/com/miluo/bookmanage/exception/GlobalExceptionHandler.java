package com.miluo.bookmanage.exception;

import com.miluo.bookmanage.utils.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public Result handleException(Exception e){
        return Result.error(-1,e.getMessage());
    }
}
