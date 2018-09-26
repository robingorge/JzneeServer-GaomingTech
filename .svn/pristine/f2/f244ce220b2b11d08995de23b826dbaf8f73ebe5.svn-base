package com.gmkw.jznee.model;

import java.io.Serializable;

public class RestResult<T> implements Serializable {
    private static final long serialVersionUID = -1749193732020261917L;
    private int code;
    private String message;
    private T object;

    public RestResult(){}

    public RestResult(int code, String message){
        this.code = code;
        this.message = message;
    }

    public RestResult(int code, String message, T object){
        this.code = code;
        this.message = message;
        this.object = object;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
