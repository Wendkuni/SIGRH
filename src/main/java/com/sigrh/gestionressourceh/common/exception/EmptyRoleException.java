package com.sigrh.gestionressourceh.common.exception;

public class EmptyRoleException extends RuntimeException{
    public EmptyRoleException(String message){
        super(message);
    }
    public EmptyRoleException(String message, Throwable throwable){
        super(message, throwable);
    }
}
