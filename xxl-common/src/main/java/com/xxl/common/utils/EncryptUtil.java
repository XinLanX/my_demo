package com.xxl.common.utils;

import com.alibaba.druid.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.SecureRandom;


/**
 * @Classname EncryptUtil
 * @Description 加解密工具类
 * @Date 2019/6/17 10:17
 * @Author Linshixiong
 */
public class EncryptUtil {

    public static final String KEY_SHA = "SHA";
    public static final String KEY_MD5 = "MD5";
    private static final String KEY_DES = "DES";
    public static final String KEY_HMD5_256 = "HmacSHA256";
    public static final String STATIC_SALT = ".";
    public static final Long NUMBER_OF_OPERATIONS = 2L;
    private static Logger logger = LoggerFactory.getLogger(EncryptUtil.class);
    private static final String[] hexDigits = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    private static String hexStr = "0123456789ABCDEF"; //全局

    public EncryptUtil() {
    }

    public static String decryptBASE64(String key) {
        return new String(Base64.base64ToByteArray(key));
    }

    public static String encryptBASE64(String key) {
        return Base64.byteArrayToBase64(key.getBytes());
    }

    public static String encryptMD5_STD(String content) {
        String resultString = "";

        try {
            MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
            md5.update(content.getBytes());
            resultString = byteArrayToHexString(md5.digest());
        } catch (Exception var3) {
            logger.error("encryptMD5 fail", var3);
        }

        return resultString.toLowerCase();
    }

    public static String encryptMD5_Salt(String content) {
        String resultString = "";
        String appkey = "fdjf,jkgfkl";
        byte[] a = appkey.getBytes();
        byte[] datSource = content.getBytes();
        byte[] b = new byte[a.length + 4 + datSource.length];

        int i;
        for (i = 0; i < datSource.length; ++i) {
            b[i] = datSource[i];
        }

        b[i++] = -93;
        b[i++] = -84;
        b[i++] = -95;
        b[i++] = -93;

        for (int k = 0; k < a.length; ++k) {
            b[i] = a[k];
            ++i;
        }

        try {
            MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
            md5.update(b);
            resultString = binaryToHexString(md5.digest());
        } catch (Exception var8) {
            logger.error("encryptMD5 fail", var8);
        }

        return resultString.toLowerCase();
    }

    public static String encryptHMac256(String content, String key) {
        String resultString = "";

        try {
            SecretKey secretKey = new SecretKeySpec(key.getBytes(), KEY_HMD5_256);
            Mac mac = Mac.getInstance(secretKey.getAlgorithm());
            mac.init(secretKey);
            byte[] digest = mac.doFinal(content.getBytes());
            resultString = Base64.byteArrayToBase64(digest);
        } catch (Exception var6) {
            logger.error("encryptHMac256 fail", var6);
        }

        return resultString;
    }

    public static String encryptMD5_FN(String content) {
        String resultString = "";
        String appkey = "fdjf,jkgfkl";
        byte[] a = appkey.getBytes();
        byte[] datSource = content.getBytes();
        byte[] b = new byte[a.length + 4 + datSource.length];

        int i;
        for (i = 0; i < datSource.length; ++i) {
            b[i] = datSource[i];
        }

        b[i++] = -93;
        b[i++] = -84;
        b[i++] = -95;
        b[i++] = -93;

        for (int k = 0; k < a.length; ++k) {
            b[i] = a[k];
            ++i;
        }

        try {
            MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
            md5.update(b);
            resultString = byteArrayToHexString(md5.digest());
        } catch (Exception var8) {
            logger.error("encryptMD5 fail", var8);
        }

        return resultString.toLowerCase();
    }

    public static byte[] encryptSHA(String content) throws Exception {
        MessageDigest sha = MessageDigest.getInstance(KEY_SHA);
        sha.update(content.getBytes());
        return sha.digest();
    }

    public static byte[] encryptDes(byte[] src, byte[] key) throws Exception {
        SecureRandom sr = new SecureRandom();
        DESKeySpec dks = new DESKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance(KEY_DES);
        cipher.init(1, securekey, sr);
        return cipher.doFinal(src);
    }

    public static byte[] decryptDes(byte[] src, byte[] key) throws Exception {
        SecureRandom sr = new SecureRandom();
        DESKeySpec dks = new DESKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance(KEY_DES);
        cipher.init(2, securekey, sr);
        return cipher.doFinal(src);
    }

//    public static String encryptDes(String data, String key) throws Exception {
//        byte[] bt = encryptDes(data.getBytes(), key.getBytes());
//        String strs = org.apache.commons.codec.binary.Base64.encodeBase64String(bt);
//        return strs;
//    }

//    public static String decrypt(String data, String key) throws Exception {
//        if (data == null) {
//            return null;
//        } else {
//            byte[] buf = org.apache.commons.codec.binary.Base64.decodeBase64(data);
//            byte[] bt = decryptDes(buf, key.getBytes());
//            return new String(bt);
//        }
//    }

    private static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();

        for (int i = 0; i < b.length; ++i) {
            resultSb.append(byteToHexString(b[i]));
        }

        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (b < 0) {
            n = 256 + b;
        }

        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

//    /**
//     * CAS 加密
//     *
//     * @param password
//     * @param key
//     * @return
//     */
//    public static String encryptCAS(String password, String key) {
//        return digestEncodedPassword(password, key, STATIC_SALT, KEY_MD5, NUMBER_OF_OPERATIONS);
//
//    }
//
//    /**
//     * cas加密工具类，参照QueryAndEncodeDatabaseAuthenticationHandler中的digestEncodedPassword实现
//     *
//     * @param encodedPass
//     * @param dynaSalt
//     * @param staticSalt
//     * @param algorithmName
//     * @param numberOfIterations
//     * @return
//     */
//    public static String digestEncodedPassword(String encodedPass, String dynaSalt, String staticSalt,
//                                               String algorithmName, Long numberOfIterations) {
//        ConfigurableHashService hashService = new DefaultHashService();
//        if (StringUtils.isNoneBlank(staticSalt)) {
//            hashService.setPrivateSalt(ByteSource.Util.bytes(staticSalt));
//        }
//
//        hashService.setHashAlgorithmName(algorithmName);
//
//        hashService.setHashIterations(numberOfIterations.intValue());
//
//        final HashRequest request = new HashRequest.Builder().setSalt(dynaSalt).setSource(encodedPass).build();
//        return hashService.computeHash(request).toHex();
//    }


    public static String binaryToHexString(byte[] bytes) {

        String result = "";
        String hex = "";
        for (int i = 0; i < bytes.length; i++) {
            //字节高4位
            hex = String.valueOf(hexStr.charAt((bytes[i] & 0xF0) >> 4));
            //字节低4位
            hex += String.valueOf(hexStr.charAt(bytes[i] & 0x0F));
            result += hex;
        }
        return result;
    }

//    public static void main(String[] args) throws Exception {
//        System.out.println(encryptMD5_Salt("funo1234")); //4794d845dc1fdb0218042c5c317ff330
//        System.out.println(encryptDes("funo1234", "11111111")); //LxmNw/6Bc7+taoi0+jeDPQ==
//        System.out.println(decrypt("LxmNw/6Bc7+taoi0+jeDPQ==", "11111111")); //4794d845dc1fdb0218042c5c317ff330
//
//    }
}
