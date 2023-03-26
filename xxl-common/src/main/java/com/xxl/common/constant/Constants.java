package com.xxl.common.constant;

/**
 * @Classname AppAuth
 * @Description 常量
 * @Date 2019/5/29 19:20
 * @Author Administrator
 */
public class Constants {

    /**
     * 操作成功
     */
    public static final int SUCCESS = 1;

    /**
     * 操作失败
     */
    public static final int FAIL = 0;

    /**
     * Mac Token
     */
    public static final String MAC_TOKEN_CACHE = "MAC_TOKEN";

    /**
     * Bearer Token
     */
    public static final String BEARER_TOKEN_CACHE = "BEARER_TOKEN";

    /**
     * SYS_USER
     */
    public static final String SYS_USER = "SYS_USER";

    /**
     * Mac Token 超时时间（秒）
     */
    public static final long MAC_TOKEN_EXPIRETIME = 60 * 60 * 24L;

    /**
     * Bearer Token 超时时间（秒）
     */
    public static final long BEARER_TOKEN_EXPIRETIME = 60 * 60 * 24 * 30L;

    /**
     * nonce
     */
    public static final String NONCE_CACHE = "NONCE";

    /**
     * nonce 超时时间（秒）
     */
    public static final long NONCE_EXPIRETIME = 60 * 5L;

    /**
     * 用户信息
     */
    public static final long SYS_USER_EXPIRETIME = 60 * 60 * 24L;

    /**
     * 当前记录起始索引
     */
    public static String PAGE_NUM = "pageNum";

    /**
     * 每页显示记录数
     */
    public static String PAGE_SIZE = "pageSize";

    /**
     * 排序列
     */
    public static String ORDER_BY_COLUMN = "orderByColumn";

    /**
     * 排序的方向 "desc" 或者 "asc".
     */
    public static String IS_ASC = "isAsc";

    /**
     * 服务端用户标识
     */
    public static String BIZ_SERVER = "99";


    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";



    /**
     * 登录成功
     */
    public static final String LOGIN_SUCCESS = "Success";

    /**
     * 注销
     */
    public static final String LOGOUT = "Logout";

    /**
     * 登录失败
     */
    public static final String LOGIN_FAIL = "Error";

    /**
     * 自动去除表前缀
     */
    public static String AUTO_REOMVE_PRE = "true";

    /**
     * 登陆成功标识
     */
    public static final String Login_SUCCESS = "0";

    /**
     * 登陆失败标识
     */
    public static final String Login_FAIL = "1";
}
