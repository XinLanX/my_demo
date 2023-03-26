package com.xxl.common.utils;


public abstract class RequestHolder {
    private static ThreadLocal<String> requestIdThreadLocal = new ThreadLocal();
    private static ThreadLocal<Long> requestStartTimeThreadLocal = new ThreadLocal();
    private static ThreadLocal<String> requestUriThreadLocal = new ThreadLocal();

    public RequestHolder() {
    }

    public static String getRequestId() {
        return (String)requestIdThreadLocal.get();
    }

    public static void setRequestId(String requestId) {
        requestIdThreadLocal.set(requestId);
    }

    public static Long getRequestStartTime() {
        return (Long)requestStartTimeThreadLocal.get();
    }

    public static void setRequestStartTime(Long requestStartTime) {
        requestStartTimeThreadLocal.set(requestStartTime);
    }

    public static String getRequestUri() {
        return (String)requestUriThreadLocal.get();
    }

    public static void setRequestUri(String requestUri) {
        requestUriThreadLocal.set(requestUri);
    }


    public static void clear() {
        requestIdThreadLocal.remove();
        requestStartTimeThreadLocal.remove();
        requestUriThreadLocal.remove();
    }
}