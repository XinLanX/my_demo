package com.xxl.common.common.exception;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.Objects;

public class UnifI18NException extends UnifException{
    private static final Logger LOGGER = LoggerFactory.getLogger(UnifI18NException.class);
    private final String code;
    private final String message;
    private final HttpStatus status;
    private final String[] args;

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public HttpStatus getStatus() {
        return this.status;
    }

    public String[] getArgs() {
        return this.args;
    }

    protected UnifI18NException(String code, String message, HttpStatus status, Throwable cause, String... args) {
        super(code, message, status, cause);
        this.code = code;
        this.message = message;
        this.status = status;
        this.args = args;
        LOGGER.error("Request Failed, HttpCode:" + status.toString() + ", Code:" + code.toString(), this);
    }

    public static UnifI18NException of(String message, String... args) {
        return of("UNFI/INTERNAL_SERVER_ERROR", message, HttpStatus.INTERNAL_SERVER_ERROR, (Throwable)null, args);
    }

    public static UnifI18NException of(String message, Throwable cause, String... args) {
        return of("UNFI/INTERNAL_SERVER_ERROR", message, HttpStatus.INTERNAL_SERVER_ERROR, cause, args);
    }

    public static UnifI18NException of(String message, IErrorCode errorCode, String... args) {
        return of(errorCode.getCode(), message, errorCode.getHttpStatus(), (Throwable)null, args);
    }

    public static UnifI18NException of(IErrorCode errorCode, String... args) {
        return of(errorCode.getCode(), errorCode.getMessage(), errorCode.getHttpStatus(), (Throwable)null, args);
    }

    public static UnifI18NException of(String code, String message, HttpStatus status, String... args) {
        return of(code, message, status, (Throwable)null, args);
    }

    public static UnifI18NException of(String message, IErrorCode errorCode, Throwable cause, String... args) {
        if (StringUtils.isBlank(message)) {
            message = errorCode.getMessage();
        }

        return of(errorCode.getCode(), message, errorCode.getHttpStatus(), cause, args);
    }

    public static UnifI18NException of(IErrorCode errorCode, Throwable cause, String... args) {
        return of(errorCode.getCode(), errorCode.getMessage(), errorCode.getHttpStatus(), cause, args);
    }

    public static UnifI18NException of(String code, String message, HttpStatus status, Throwable cause, String... args) {
        String[] i18nArgs = new String[args.length];

        for(int i = 0; i < args.length; ++i) {
            i18nArgs[i] = I18NUtil.getDefaultI18NMsg(args[i], args[i], new Object[0]);
        }

        message = I18NUtil.getDefaultI18NMsg(message, message, i18nArgs);
        return new UnifI18NException(code, message, status, cause, new String[0]);
    }


}
