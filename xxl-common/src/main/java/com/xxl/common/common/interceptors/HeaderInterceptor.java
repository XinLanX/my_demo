package com.xxl.common.common.interceptors;

import com.xxl.common.constant.ErrorCode;
import com.xxl.common.utils.RequestHolder;
import com.xxl.common.utils.ServletUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.DefaultServletHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class HeaderInterceptor  implements HandlerInterceptor {


    private static final Logger log = LoggerFactory.getLogger(HandlerInterceptor.class);

    public HeaderInterceptor(){
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String ip = ServletUtil.getRemortIP(request);
        String url = ServletUtil.getUrlWithParams(request);
        String method = request.getMethod();
        if (log.isInfoEnabled()){
            String requestId = System.currentTimeMillis() + RandomStringUtils.randomAlphabetic(6);
            RequestHolder.setRequestId(requestId);
            RequestHolder.setRequestStartTime(Long.valueOf(System.currentTimeMillis()));
            RequestHolder.setRequestUri("[" + method + "] " + url);
            log.info("requestId: " + requestId + " ,request url:" + url + ", method:" + method + ", ip:" + ip + ")");
        }

        if ((handler instanceof DefaultServletHttpRequestHandler)) {
//            throw UnifI18NException.of(ErrorCode.NOT_FOUND);
            System.out.println(ErrorCode.NOT_FOUND);
            //return false;
        }

        if (request.getMethod().equalsIgnoreCase(HttpMethod.OPTIONS.name())) {
            return true;
        }

        if(1==1){
            return true;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
