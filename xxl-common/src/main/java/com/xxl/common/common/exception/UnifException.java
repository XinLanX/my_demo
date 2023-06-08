package com.xxl.common.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class UnifException extends RuntimeException {
    private ResponseEntity<ErrorMessage> responseEntity;

    public UnifException(ResponseEntity<ErrorMessage> responseEntity, Throwable cause) {
        super(((ErrorMessage)responseEntity.getBody()).getMessage(), cause);
        this.responseEntity = responseEntity;
    }

    public UnifException(ResponseEntity<ErrorMessage> responseEntity) {
        this((ResponseEntity)responseEntity, (Throwable)null);
    }

    public UnifException(ErrorMessage errorMessage, HttpStatus status, Throwable cause) {
        this(new ResponseEntity(errorMessage, status), cause);
    }

    public UnifException(ErrorMessage errorMessage, HttpStatus status) {
        this(new ResponseEntity(errorMessage, status));
    }

    public UnifException(String code, String message, String detail, HttpStatus status, Throwable cause) {
        this(new ErrorMessage(code, message, detail), status, cause);
    }

    public UnifException(String code, String message, String detail, HttpStatus status) {
        this((ErrorMessage)(new ErrorMessage(code, message, detail)), (HttpStatus)status, (Throwable)null);
    }

    public UnifException(String code, String message, HttpStatus status, Throwable cause) {
        this(new ErrorMessage(code, message), status, cause);
    }

    public UnifException(String code, String message, HttpStatus status) {
        this(code, message, (HttpStatus)status, (Throwable)null);
    }

    public UnifException(String code, String message, Throwable cause) {
        this(new ErrorMessage(code, message), HttpStatus.INTERNAL_SERVER_ERROR, cause);
    }

    public UnifException(String code, String message) {
        this(code, message, (Throwable)null);
    }

    public ResponseEntity<ErrorMessage> getResponseEntity() {
        return this.responseEntity;
    }

    public ErrorMessage getError() {
        return (ErrorMessage)this.responseEntity.getBody();
    }

}
