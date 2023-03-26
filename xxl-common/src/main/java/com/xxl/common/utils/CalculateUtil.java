package com.xxl.common.utils;

import org.apache.commons.lang3.ObjectUtils;

import java.util.Iterator;
import java.util.Random;

/**
 * @Classname CalculateUtil
 * @Description TODO
 * @Date 2019/6/17 11:38
 * @Author Linshixiong
 */
public class CalculateUtil {

    private static final String RANDOM_STR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final String IDENTIFYCODE_RANDOM_STR = "abcdefghjkmnpqrstuvwxyABCDEFGHJKMNPQRSTUVWXY3456789";

    public CalculateUtil() {
    }

    public static int getNext(int min, int max) {
        Random random = new Random();
        int s = random.nextInt(max) % (max - min + 1) + min;
        return s;
    }

    public static int getNext(int max) {
        Random random = new Random();
        int s = random.nextInt(max);
        return s;
    }

    public static String generateDigitRandomCode(int sum) {
        Random rd = new Random();
        String n = "";

        do {
            int getNum = Math.abs(rd.nextInt(Integer.MAX_VALUE)) % 10 + 48;
            char num1 = (char) getNum;
            String dn = Character.toString(num1);
            n = n + dn;
        } while (n.length() < sum);

        return n;
    }

    public static String generateMixRandomCode(int sum) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < sum; ++i) {
            int number = random.nextInt(62);
            sb.append(RANDOM_STR.charAt(number));
        }

        return sb.toString();
    }

    public static String generateIdentifyCodeRandomCode(int sum) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < sum; ++i) {
            int number = random.nextInt(51);
            sb.append(IDENTIFYCODE_RANDOM_STR.charAt(number));
        }

        return sb.toString();
    }

    public static long ipAddressToLong(String ipAddress) {
        long ipInt = 0L;
        if (ValidatorUtil.isIPv4Address(ipAddress)) {
            String[] ipArr = ipAddress.split("\\.");
            if (ipArr.length == 3) {
                ipAddress = ipAddress + ".0";
            }

            ipArr = ipAddress.split("\\.");
            long p1 = Long.parseLong(ipArr[0]) * 256L * 256L * 256L;
            long p2 = Long.parseLong(ipArr[1]) * 256L * 256L;
            long p3 = Long.parseLong(ipArr[2]) * 256L;
            long p4 = Long.parseLong(ipArr[3]);
            ipInt = p1 + p2 + p3 + p4;
        }

        return ipInt;
    }

    public static String cast2Conf(Iterable<?> iterable, String separator) {
        if (iterable == null) {
            return null;
        } else {
            Iterator<?> iterator = iterable.iterator();
            if (iterator == null) {
                return null;
            } else if (!iterator.hasNext()) {
                return null;
            } else {
                StringBuilder buf = new StringBuilder(256);
                Object first = iterator.next();
                if (!iterator.hasNext()) {
                    buf.append("'");
                    String result = ObjectUtils.toString(first);
                    buf.append(result);
                    buf.append("'");
                    return buf.toString();
                } else {
                    if (first != null) {
                        buf.append("'");
                        buf.append(first);
                        buf.append("'");
                    }

                    while (iterator.hasNext()) {
                        if (separator != null) {
                            buf.append(separator);
                        }

                        Object obj = iterator.next();
                        if (obj != null) {
                            buf.append("'");
                            buf.append(obj);
                            buf.append("'");
                        }
                    }

                    return buf.toString();
                }
            }
        }
    }
}
