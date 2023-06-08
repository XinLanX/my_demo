package com.xxl.common.common.exceptionDefine;

public class SelfDefineException extends Exception{
    private String message;

    public SelfDefineException(String message){
        super(message);
    }

}
