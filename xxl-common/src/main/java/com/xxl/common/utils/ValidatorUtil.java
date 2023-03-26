package com.xxl.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Classname ValidatorUtil
 * @Description 验证工具类
 * @Date 2019/6/17 10:15
 * @Author Linshixiong
 */
public class ValidatorUtil {

    public ValidatorUtil() {
    }

    public static boolean isMobile(String str) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        if (StringUtils.isBlank(str)) {
            return b;
        } else {
            p = Pattern.compile("^[1][3,4,5,6,7,8,9][0-9]{9}$");
            m = p.matcher(str);
            b = m.matches();
            return b;
        }
    }

    public static boolean isInternalMobile(String str) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        if (StringUtils.isBlank(str)) {
            return b;
        } else {
            p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$");
            m = p.matcher(str);
            b = m.matches();
            return b;
        }
    }

    public static boolean isMobile(String str, String countryCode) {
        return !StringUtils.isBlank(countryCode) && !countryCode.contains("+86") ? isAbroadMobile(str) : isMobile(str);
    }

    public static boolean isAbroadMobile(String str) {
        return str.length() <= 21 && str.length() >= 7 ? isNumeric(str) : false;
    }

    public static boolean isNumeric(String str) {
        if (StringUtils.isBlank(str)) {
            return false;
        } else {
            return str.matches("\\d*");
        }
    }

    public static boolean isLong(String str) {
        boolean b = true;

        try {
            Long.valueOf(str);
        } catch (Exception var3) {
            b = false;
        }

        return b;
    }

    public static boolean isPasswd(String passwd) {
        if (StringUtils.isBlank(passwd)) {
            return false;
        } else if (passwd.length() >= 6 && passwd.length() <= 12) {
            String regEx = "^[A-Za-z0-9_]+$";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(passwd);
            return m.matches();
        } else {
            return false;
        }
    }

    public static boolean isIPv4Address(String input) {
        Pattern IPV4_PATTERN = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
        return IPV4_PATTERN.matcher(input).matches();
    }

    public static boolean isMac(String mac) {
        if (StringUtils.isNotBlank(mac)) {
            mac = mac.toUpperCase();
            String patternMac = "^[A-F0-9]{2}(:[A-F0-9]{2}){5}$";
            if (Pattern.compile(patternMac).matcher(mac).find()) {
                return true;
            }
        }

        return false;
    }

    public static boolean isUsername(String username) {
        if (StringUtils.isBlank(username)) {
            return false;
        } else if (username.length() > 20) {
            return false;
        } else {
            String regEx = "^[A-Za-z][A-Za-z0-9_]*$";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(username);
            return m.matches();
        }
    }

    public static boolean isExInfoKeyValid(String key) {
        if (StringUtils.isBlank(key)) {
            return false;
        } else if (key.length() > 20) {
            return false;
        } else {
            String regEx = "^[A-Za-z][A-Za-z0-9_]*$";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(key);
            return m.matches();
        }
    }

    public static boolean isRealmExInfoKeyValid(String key) {
        if (StringUtils.isBlank(key)) {
            return false;
        } else {
            String regEx = "^[A-Za-z][A-Za-z0-9_]*$";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(key);
            return m.matches();
        }
    }

    public static boolean isExInfoKeyValid(Map<String, Object> exinfoMap) {
        if (CollectionUtils.isEmpty(exinfoMap)) {
            return true;
        } else {
            Iterator i$ = exinfoMap.entrySet().iterator();

            Map.Entry entry;
            do {
                if (!i$.hasNext()) {
                    return true;
                }

                entry = (Map.Entry) i$.next();
            } while (isExInfoKeyValid((String) entry.getKey()));

            return false;
        }
    }

    public static boolean isUserRealmExInfoKeyValid(Map<String, Object> exinfoMap) {
        if (CollectionUtils.isEmpty(exinfoMap)) {
            return true;
        } else {
            String[] keys = null;
            Iterator i$ = exinfoMap.entrySet().iterator();

            label40:
            while (i$.hasNext()) {
                Map.Entry<String, Object> entry = (Map.Entry) i$.next();
                if (StringUtils.isBlank((CharSequence) entry.getKey())) {
                    return false;
                }

                if (((String) entry.getKey()).length() > 100) {
                    return false;
                }

                keys = ((String) entry.getKey()).split("\\.");
                if (null != keys && keys.length > 1) {
                    int i = 0;

                    while (true) {
                        if (i >= keys.length) {
                            continue label40;
                        }

                        if (!isRealmExInfoKeyValid(keys[i])) {
                            return false;
                        }

                        ++i;
                    }
                }

                return false;
            }

            return true;
        }
    }

    public static boolean isOrgNameValid(String orgName) {
        if (StringUtils.isBlank(orgName)) {
            return false;
        } else if (orgName.length() > 50) {
            return false;
        } else {
            String regEx = "^[A-Za-z0-9_]*$";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(orgName);
            return m.matches();
        }
    }

    public static boolean isContainsChinese(String source) {
        Pattern pat = Pattern.compile("[\u4e00-\u9fa5]");
        boolean flag = false;
        Matcher matcher = pat.matcher(source);
        if (matcher.find()) {
            flag = true;
        }

        return flag;
    }


    public static boolean isOrgUserCodeValid(String orgUserCode) {
        if (StringUtils.isBlank(orgUserCode)) {
            return false;
        } else if (orgUserCode.length() > 50) {
            return false;
        } else if (isMobile(orgUserCode)) {
            return false;
        } else {
            String regEx = "^[A-Za-z0-9_@.]*$";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(orgUserCode);
            return m.matches();
        }
    }

    public static boolean isLoginNameValid(String loginName) {
        if (StringUtils.isBlank(loginName)) {
            return false;
        } else if (loginName.length() > 50) {
            return false;
        } else {
            String regEx = "^[A-Za-z0-9_@.\\-]*$";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(loginName);
            return m.matches();
        }
    }

    public static boolean isNickNameValid(String nickName) {
        return null != nickName && nickName.length() <= 50 && (nickName.isEmpty() || !nickName.trim().isEmpty());
    }

    public static boolean isNodeNameValid(String nodeName) {
        if (StringUtils.isBlank(nodeName)) {
            return false;
        } else {
            return nodeName.length() <= 100;
        }
    }

    public static boolean isRealNameValid(String realName) {
        if (StringUtils.isBlank(realName)) {
            return false;
        } else if (realName.length() > 50) {
            return false;
        } else {
            return !isMb4(realName);
        }
    }

    public static boolean isOrgFullNameValid(String orgFullName) {
        if (StringUtils.isBlank(orgFullName)) {
            return false;
        } else {
            return orgFullName.length() <= 100;
        }
    }

    public static boolean isSmsContentValid(String smsContet) {
        if (StringUtils.isBlank(smsContet)) {
            return false;
        } else if (smsContet.length() > 70) {
            return false;
        } else if (!smsContet.contains("【") && !smsContet.contains("】") && !smsContet.contains("{") && !smsContet.contains("}") && !smsContet.contains("[") && !smsContet.contains("]")) {
            return smsContet.contains("%1$s");
        } else {
            return false;
        }
    }

    public static boolean isLimitValid(int limit) {
        return limit == -1 || limit > 0;
    }

    public static boolean isOffsetValid(Integer offset) {
        return offset >= 0;
    }


    public static boolean isRoleNameValid(String roleName) {
        if (StringUtils.isBlank(roleName)) {
            return false;
        } else if (roleName.length() > 50) {
            return false;
        } else {
            String regEx = "^[A-Za-z][A-Za-z0-9_]*$";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(roleName);
            return m.matches();
        }
    }

    public static boolean isKeyValid(String key) {
        if (StringUtils.isBlank(key)) {
            return false;
        } else {
            return !key.contains("%");
        }
    }

    public static boolean isEnableValid(Integer enableStatus) {
        return enableStatus == 1 || enableStatus == 0;
    }

    public static boolean isEnableValid(String str) {
        return str.equals(String.valueOf(1)) || str.equals(String.valueOf(0));
    }

    public static boolean isRemarkValid(String remark) {
        return StringUtils.isBlank(remark) || remark.length() <= 250;
    }

    public static boolean isCountryCodeValid(String str) {
        if (StringUtils.isNotBlank(str)) {
            if (str.length() > 16) {
                return false;
            } else {
                Pattern p = null;
                Matcher m = null;
                boolean b = false;
                p = Pattern.compile("^[\\+][0-9]*$");
                m = p.matcher(str);
                b = m.matches();
                return b;
            }
        } else {
            return true;
        }
    }

    public static void filterUcReserveAttr(Map<String, Object> orgExinfo) {
        if (!CollectionUtils.isEmpty(orgExinfo)) {
            orgExinfo.remove("org_id");
            orgExinfo.remove("node_id");
            orgExinfo.remove("org_name");
            orgExinfo.remove("node_name");
            orgExinfo.remove("node_items");
            orgExinfo.remove("current_node");
            orgExinfo.remove("v_org_id");
        }

    }

    public static boolean isEmailValid(String str) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        if (StringUtils.isBlank(str)) {
            return b;
        } else if (str.length() > 100) {
            return b;
        } else {
            p = Pattern.compile("^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$");
            m = p.matcher(str);
            b = m.matches();
            return b;
        }
    }

    public static boolean isEmailContentValid(String emailContent) {
        if (StringUtils.isBlank(emailContent)) {
            return false;
        } else if (emailContent.length() > 1000) {
            return false;
        } else {
            return emailContent.contains("%1$s") && emailContent.contains("%2$s");
        }
    }


    public static boolean isExpireTimeValid(Integer expireTime) {
        return expireTime >= 1;
    }

    public static boolean isDeviceTypeValid(Integer fromDevice) {
        if (fromDevice == null) {
            return true;
        } else {
            return fromDevice == 1 || fromDevice == 2;
        }
    }

    public static boolean isCrucialValid(Integer isCrucial) {
        if (isCrucial == null) {
            return true;
        } else {
            return isCrucial == 0 || isCrucial == 1;
        }
    }

    public static boolean isDeviceIdValid(String deviceId) {
        return StringUtils.isNotBlank(deviceId) && deviceId.length() <= 128;
    }

    public static boolean checkDeviceIdStrict(String deviceId) {
        if (!StringUtils.isBlank(deviceId) && deviceId.length() > 3) {
            String originalDeviceId = deviceId.substring(2);
            char reqVerifyChar = deviceId.charAt(0);
            char b = EncryptUtil.encryptBASE64(EncryptUtil.encryptMD5_FN(originalDeviceId)).charAt(2);
            return reqVerifyChar == b;
        } else {
            return false;
        }
    }

    public static boolean isResetUriValid(String resetUri) {
        return !StringUtils.isNotBlank(resetUri) || resetUri.startsWith("http://") || resetUri.startsWith("https://");
    }

    public static boolean isMb4(String s) {
        int len = s.length();
        return len != s.codePointCount(0, len);
    }

    public static String filterEmoji(String source) {
        if (StringUtils.isBlank(source)) {
            return source;
        } else {
            StringBuilder buf = null;
            int len = source.length();

            for (int i = 0; i < len; ++i) {
                char codePoint = source.charAt(i);
                if (isEmojiCharacter(codePoint)) {
                    if (buf == null) {
                        buf = new StringBuilder(source.length());
                    }

                    buf.append(codePoint);
                }
            }

            if (buf == null) {
                return source;
            } else if (buf.length() == len) {
                buf = null;
                return source;
            } else {
                return buf.toString();
            }
        }
    }

    private static boolean isEmojiCharacter(char codePoint) {
        return codePoint == 0 || codePoint == '\t' || codePoint == '\n' || codePoint == '\r' || codePoint >= ' ' && codePoint <= '\ud7ff' || codePoint >= '\ue000' && codePoint <= '�' || codePoint >= 65536 && codePoint <= 1114111;
    }

//    public static void main(String[] args) {
//        System.out.println(isLoginNameValid("v-_v@a.c"));
//    }
}
