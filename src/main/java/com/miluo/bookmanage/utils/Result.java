package com.miluo.bookmanage.utils;

import lombok.Data;

@Data
public class Result<T> {

    private Integer code;

    private T data;

    private String message;

    private Result(T data) {
        this.code = 0;
        this.data = data;
    }

    private Result(T data,Integer code) {
        this.code = code;
        this.data = data;
    }

    private Result(Integer code,String message) {
        this.code = code;
        this.message = message;
    }

    public static <T>Result<T> success( T data ){
        return new Result<T>(data);
    }

    public static <T>Result<T> error(Integer code,String message){
        return new Result<T>(code,message);
    }

    public static <T>Result<T> error(Integer code){
        return new Result<T>(code,null);
    }
}
