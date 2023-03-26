package com.xxl.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServletUtil {

    public ServletUtil() {
    }

    public static String getRemortIP(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        if (ip.startsWith(",")) {
            ip = ip.substring(1, ip.length());
        }

        return ip;
    }

    public static String getUrlWithParams(HttpServletRequest request) {
        String url = request.getRequestURI();
        if (StringUtils.isNotBlank(request.getQueryString()) && (!request.getQueryString().contains("callback") || !request.getQueryString().contains("proxy=proxyhttp"))) {
            url = url + "?" + request.getQueryString();
        }

        return url;
    }

    public static String getAccessToken(HttpServletRequest request) {
        String accessToken = null;
        String authorization = request.getHeader("Authorization");
        if (StringUtils.isBlank(authorization)) {
            return (String)accessToken;
        } else {
            Pattern p;
            Matcher m;
            if (authorization.startsWith("MAC")) {
                p = Pattern.compile("MAC id=\"(.*)\",nonce=\"(.*)\",mac=\"(.*)\"");
                m = p.matcher(authorization);
                if (m.find() && StringUtils.isNotBlank(m.group(1))) {
                    return m.group(1);
                }
            } else if (authorization.startsWith("Bearer")) {
                p = Pattern.compile("Bearer \"(.*)\"");
                m = p.matcher(authorization);
                if (m.find() && StringUtils.isNotBlank(m.group(1))) {
                    return m.group(1);
                }
            } else if (authorization.startsWith("BGW")) {
                p = Pattern.compile("BGW \"(.*)\"");
                m = p.matcher(authorization);
                if (m.find() && StringUtils.isNotBlank(m.group(1))) {
                    return m.group(1);
                }
            } else if (authorization.startsWith("Debug")) {
                p = Pattern.compile("Debug userId=(.*)");
                m = p.matcher(authorization);
                if (m.find() && StringUtils.isNotBlank(m.group(1))) {
                    return m.group(1);
                }
            }

            return (String)accessToken;
        }
    }

    public static String getParameter(String name) {
        return getRequest().getParameter(name);
    }

    public static String getParameter(String name, String defaultValue) {
        return Convert.toStr(getRequest().getParameter(name), defaultValue);
    }

    public static Integer getParameterToInt(String name) {
        return Convert.toInt(getRequest().getParameter(name));
    }

    public static Integer getParameterToInt(String name, Integer defaultValue) {
        return Convert.toInt(getRequest().getParameter(name), defaultValue);
    }

    public static HttpServletRequest getRequest() {
        return getRequestAttributes().getRequest();
    }

    public static HttpServletResponse getResponse() {
        return getRequestAttributes().getResponse();
    }

    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    public static ServletRequestAttributes getRequestAttributes() {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        return (ServletRequestAttributes)attributes;
    }
}
