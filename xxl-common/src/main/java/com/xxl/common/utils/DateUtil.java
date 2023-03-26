package com.xxl.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String formatDateTime(Date date) {
        return DATE_TIME_FORMAT.format(date);
    }
}
