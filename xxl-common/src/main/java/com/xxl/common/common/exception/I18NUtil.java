package com.xxl.common.common.exception;


import org.apache.commons.lang3.ArrayUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;

public class I18NUtil {
    private static MessageSource messageSource;

    private I18NUtil() {
    }

    public static MessageSource messageSource() {
        return messageSource;
    }

    public static String getI18NMsg(String code, Object... args) {
        return messageSource.getMessage(code, args, (String)null, LocaleContextHolder.getLocale());
    }

    public static String getDefaultI18NMsg(String code, String defaultMessage, Object... args) {
        return messageSource.getMessage(code, args, defaultMessage, LocaleContextHolder.getLocale());
    }

    static {
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        String[] commonBasenames = new String[]{"common-module", "error-code"};
//        String[] customBasenames = UnifContext.getI18NBasenames();
//        String[] basenames = (String[]) ArrayUtils.addAll(commonBasenames, customBasenames);
//        resourceBundleMessageSource.setBasenames(basenames);
        resourceBundleMessageSource.setDefaultEncoding("UTF-8");
        messageSource = resourceBundleMessageSource;
    }
}
