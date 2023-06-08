package com.xxl.common.common.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class ResponseErrorMessage extends ErrorMessage implements Cloneable {
    private String hostId;
    private String requestId;
    private Date serverTime;
    private Throwable throwable;

    public ResponseErrorMessage() {
    }

    public ResponseErrorMessage(Throwable throwable) {
        this.throwable = throwable;
    }

    public String getHostId() {
        return this.hostId;
    }

    public void setHostId(String hostId) {
        this.hostId = hostId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Date getServerTime() {
        return this.serverTime;
    }

    public void setServerTime(Date serverTime) {
        this.serverTime = serverTime;
    }

    @JsonIgnore
    public Throwable getThrowable() {
        return this.throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder("<");
        builder.append("code:").append(this.getCode()).append(", message:").append(this.getMessage()).append(", host_id:").append(this.hostId).append(", server_time:").append(this.serverTime).append(", request_id:").append(this.requestId).append(", detail:").append(this.getDetail()).append(">");
        return builder.toString();
    }

    public ResponseErrorMessage clone() {
        try {
            return (ResponseErrorMessage)super.clone();
        } catch (CloneNotSupportedException var2) {
            throw new RuntimeException(var2);
        }
    }
}
