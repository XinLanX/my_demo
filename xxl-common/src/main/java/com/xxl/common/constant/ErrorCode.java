package com.xxl.common.constant;

import org.springframework.http.HttpStatus;

/**
 * @Classname ErrorCode
 * @Description TODO
 * @Date 2019/6/3 10:01
 * @Author Administrator
 */
public enum ErrorCode {


    //用户类
    LOGINNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "ACCOUNT_NOT_EXIST", "用户名或密码错误"),
    LOGINNAME_EXIST(HttpStatus.BAD_REQUEST, "LOGINNAME_EXIST", "用户名称已存在"),
    ACCOUNT_NOT_EXIST(HttpStatus.BAD_REQUEST, "ACCOUNT_NOT_EXIST", "帐号不存在"),
    ACCOUNT_DISABLE(HttpStatus.BAD_REQUEST, "ACCOUNT_DISABLE", "帐号已禁用"),
    ACCOUNT_UN_ENABLE(HttpStatus.BAD_REQUEST, "ACCOUNT_UN_ENABLE", "帐号未启用"),
    ACCOUNT_LOCKED(HttpStatus.BAD_REQUEST, "ACCOUNT_LOCKED", "帐号登录错误次数太多，被锁定！请5分钟后再登录！"),
    ACCOUNT_NOT_PASSPORT_GLOBAL(HttpStatus.BAD_REQUEST, "ACCOUNT_NOT_PASSPORT_GLOBAL", "帐号未关联passport"),
    ACCOUNT_NOT_ND_GLOBAL(HttpStatus.BAD_REQUEST, "ACCOUNT_NOT_PASSPORT_GLOBAL", "帐号未关联ND"),
    PASSWORD_NOT_CORRECT(HttpStatus.BAD_REQUEST, "PASSWORD_NOT_CORRECT", "用户名或密码错误"),
    PASSWORD_SAME(HttpStatus.BAD_REQUEST, "PASSWORD_SAME", "新密码与原密码不能相同"),
    USER_LOCK(HttpStatus.BAD_REQUEST, "USER_LOCK", "用户密码错误超过6次！账户锁定，请一天后重试"),
    OLDPASSWORD_INVALID(HttpStatus.BAD_REQUEST, "OLDPASSWORD_INVALID", "原密码不正确"),
    OLDPASSWORD_BLANK(HttpStatus.BAD_REQUEST, "OLDPASSWORD_BLANK", "原密码不能为空"),
    NEWPASSWORD_BLANK(HttpStatus.BAD_REQUEST, "NEWPASSWORD_BLANK", "新密码不能为空"),
    LOGIN_FAILURE(HttpStatus.INTERNAL_SERVER_ERROR, "LOGIN_FAILURE", "登录失败"),
    NONCE_INVALID(HttpStatus.UNAUTHORIZED, "NONCE_INVALID", "令牌认证Key已被使用"),
    AUTH_INVALID_TIMESTAMP(HttpStatus.UNAUTHORIZED, "AUTH_INVALID_TIMESTAMP", "无效的令牌认证Key，令牌认证Key已超过5分钟有效期"),
    AUTH_INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "AUTH_INVALID_TOKEN", "身份信息已失效，请重新登录"),
    AUTH_UNAVAILABLE_TOKEN(HttpStatus.UNAUTHORIZED, "AUTH_UNAVAILABLE_TOKEN", "不可用授权令牌"),
    AUTH_TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, "AUTH_TOKEN_EXPIRED", "授权令牌已过期"),
    MAC_SIGN_INVALID(HttpStatus.UNAUTHORIZED, "MAC_SIGN_INVALID", "Mac签名错误"),
    SIGN_ALREADY_USED(HttpStatus.UNAUTHORIZED, "SIGN_ALREADY_USED", "签名已被使用"),
    TOKEN_REFRESH_FAILURE(HttpStatus.INTERNAL_SERVER_ERROR, "TOKEN_REFRESH_FAILURE", "令牌更新失败"),
    LOGOUT_FAILURE(HttpStatus.INTERNAL_SERVER_ERROR, "LOGOUT_FAILURE", "退出失败"),
    PHONE_NUMBER_FORMAT_INVALID(HttpStatus.BAD_REQUEST, "PHONE_NUMBER_FORMAT_INVALID", "手机号码格式不正确"),
    USER_PASSWORD_BLANK(HttpStatus.UNAUTHORIZED, "USER_PASSWORD_BLANK", "用户名或密码不能为空"),
    INVALID_LOGIN_NAME(HttpStatus.BAD_REQUEST, "INVALID_LOGIN_NAME", "登录名格式不正确,只能包括字母、数字、_、-、.、@，最长50字符"),
    LOGIN_NAME_BLANK(HttpStatus.BAD_REQUEST, "LOGIN_NAME_BLANK", "登录名不能为空"),
    REQUIRE_ARGUMENT(HttpStatus.BAD_REQUEST, "REQUIRE_ARGUMENT", "缺少参数"),
    INVALID_ARGUMENT(HttpStatus.BAD_REQUEST, "INVALID_ARGUMENT", "输入参数格式不正确"),
    INVALID_PERSIST(HttpStatus.BAD_REQUEST, "INVALID_PERSIST", "参数persist取值不正确,只能是0或1"),
    USER_NOT_EXIST(HttpStatus.BAD_REQUEST, "USER_NOT_EXIST", "用户不存在"),
    LOGINNAME_NOT_MODIFY(HttpStatus.BAD_REQUEST, "LOGINNAME_NOT_MODIFY", "登陆名不可修改"),
    NOT_FOUND(HttpStatus.BAD_REQUEST, "NOT_FOUND", "请求的URL路径不存在!"),
    MISS_AUTH(HttpStatus.FORBIDDEN, "MISS_AUTH", "请求头缺少Authorization信息!"),
    MISS_ORIGIN_HOST(HttpStatus.FORBIDDEN, "MISS_ORIGIN_HOST", "请求头部信息 Origin-Host 不能为空"),
    MISS_REQUEST_URL(HttpStatus.FORBIDDEN, "MISS_REQUEST_URL", "请求头部信息 Request-Url 不能为空"),
    NOT_BEARER_USER(HttpStatus.BAD_REQUEST, "NOT_BEARER_USER", "您不是内部服务端用户，不能进行服务端登入"),
    NOT_BGW_USER(HttpStatus.BAD_REQUEST, "NOT_BGW_USER", "您不是网关用户，不能进行网关用户登入"),
    NOT_BTS_USER(HttpStatus.BAD_REQUEST, "NOT_BTS_USER", "您不是外部服务端用户，不能进行服务端登入"),
    NOT_MAC_USER(HttpStatus.BAD_REQUEST, "NOT_MAC_USER", "服务端用户不能登入"),
    NOT_FRONT_USER(HttpStatus.BAD_REQUEST, "NOT_FRONT_USER", "您不是前台用户，不能进行前台登入"),
    NOT_AKSK_USER(HttpStatus.BAD_REQUEST, "NOT_AKSK_USER", "应用认证失败，非AKSK授权应用"),
    PASSWORD_DAYS_EXCEED(HttpStatus.FORBIDDEN, "PASSWORD_DAYS_EXCEED", "密码超过有效期(90天)，请立即修改"),
    BIZSERVER_USER(HttpStatus.BAD_REQUEST, "BIZSERVER_USER", "服务端用户"),
    AUTH_MAC_TOKEN_INVALID(HttpStatus.BAD_REQUEST, "AUTH_MAC_TOKEN_INVALID", "请求Mac token协议的Authorization认证头格式不正确"),
    AUTH_BTS_TOKEN_INVALID(HttpStatus.BAD_REQUEST, "AUTH_BTS_TOKEN_INVALID", "请求BTS token协议的Authorization认证头格式不正确"),
    AUTH_UNAVAILABLE(HttpStatus.UNAUTHORIZED, "AUTH_UNAVAILABLE", "未授权的访问"),
    INVALID_LOGIN_MAC(HttpStatus.UNAUTHORIZED, "INVALID_LOGIN_MAC", "MAC格式不正确"),
    DECRPYT_ERROR(HttpStatus.UNAUTHORIZED, "DECRPYT_ERROR", "解密失败"),


    //组织类
    ORGID_BLANK(HttpStatus.BAD_REQUEST, "ORGNAME_BLANK", "组织ID不能为空"),
    ORGNAME_BLANK(HttpStatus.BAD_REQUEST, "ORGNAME_BLANK", "组织名不能为空"),
    ORGNAME_INVALID(HttpStatus.BAD_REQUEST, "ORGNAME_INVALID", "组织名格式不正确,只允许字母、数字、_，最长50字符"),
    ORG_NOT_EXIST(HttpStatus.BAD_REQUEST, "ORG_NOT_EXIST", "指定的组织不存在"),
    INVALID_ORG_FULL_NAME(HttpStatus.BAD_REQUEST, "INVALID_ORG_FULL_NAME", "组织全名不能为空且长度不能超过200字节"),
    ORG_NAME_EXIST(HttpStatus.BAD_REQUEST, "ORG_NAME_EXIST", "组织名称已存在"),
    NODE_STOPPED(HttpStatus.BAD_REQUEST, "NODE_STOPPED", "部门停用，不允许新增"),

    //字典类
    DICT_ALLOCATED(HttpStatus.BAD_REQUEST, "DICT_ALLOCATED", "字典已分配,不能删除"),

    //验证码类
    CAPTCHA_EXPIRE(HttpStatus.BAD_REQUEST, "CAPTCHA_EXPIRE", "验证码已失效"),
    CAPTCHA_WRONG(HttpStatus.BAD_REQUEST, "CAPTCHA_WRONG", "验证码错误"),
    CAPTCHA_BLANK(HttpStatus.BAD_REQUEST, "CAPTCHA_BLANK", "验证码不能为空"),
    CAPTCHA_INPUT(HttpStatus.BAD_REQUEST, "CAPTCHA_INPUT", "请先输入正确的验证码"),
    CAPTCHA_SEND_ERROR(HttpStatus.BAD_REQUEST, "CAPTCHA_SEND_ERROR", "短信验证码发送错误"),
    CAPTCHA_SMS_ERROR(HttpStatus.BAD_REQUEST, "CAPTCHA_SMS_ERROR", "短信验证码错误"),
    CAPTCHA_SHOW(HttpStatus.BAD_REQUEST, "CAPTCHA_SHOW", "用户名或密码错误"),


    //岗位类
    POST_ALLOCATED(HttpStatus.BAD_REQUEST, "POST_ALLOCATED", "岗位已分配,不能删除"),
    POST_DELETE_FAILED(HttpStatus.BAD_REQUEST, "POST_DELETE_FAILURE", "岗位删除失败"),

    //个人信息类
    AVATAR_UPDATE_FAILED(HttpStatus.BAD_REQUEST, "AVATAR_UPDATE_FAILED", "头像更新失败"),

    //权限角色类
    PRICODE_BLANK(HttpStatus.BAD_REQUEST, "PRICODE_BLANK", "权限编码不能为空"),
    PRIID_BLANK(HttpStatus.BAD_REQUEST, "PRIID_BLANK", "权限ID不能为空"),
    PRINAME_BLANK(HttpStatus.BAD_REQUEST, "PRINAME_BLANK", "权限名称不能为空"),
    PRITYPE_BLANK(HttpStatus.BAD_REQUEST, "PRITYPE_BLANK", "权限类型不能为空"),
    PRICODE_EXIST(HttpStatus.BAD_REQUEST, "PRICODE_EXIST", "权限编码已存在"),
    ROLECODE_BLANK(HttpStatus.BAD_REQUEST, "ROLECODE_BLANK", "角色编码不能为空"),
    ROLEID_BLANK(HttpStatus.BAD_REQUEST, "ROLEID_BLANK", "角色ID不能为空"),
    ROLENAME_BLANK(HttpStatus.BAD_REQUEST, "ROLENAME_BLANK", "角色名称不能为空"),
    ROLETYPE_BLANK(HttpStatus.BAD_REQUEST, "ROLETYPE_BLANK", "角色类型不能为空"),
    ROLECODE_EXIST(HttpStatus.BAD_REQUEST, "PRICODE_BLANK", "角色编码已存在"),
    USERID_BLANK(HttpStatus.BAD_REQUEST, "USERID_BLANK", "用户ID不能为空"),
    ROLE_ALLOCATED(HttpStatus.BAD_REQUEST, "ROLE_ALLOCATED", "角色已分配,不能删除"),
    SUPERADMIN_NOT_ALLOWED_DELETE(HttpStatus.BAD_REQUEST, "SUPERADMIN_NOT_ALLOWED_DELETE", "不允许删除超级管理员用户"),
    IMPORT_USER_DATA_EMPTY(HttpStatus.BAD_REQUEST, "IMPORT_USER_DATA_EMPTY", "导入用户数据不能为空"),
    EXCEED_USER_DATA(HttpStatus.BAD_REQUEST, "EXCEED_USER_DATA", "导入数据不能超过1000条"),
    IMPORT_FAILURE(HttpStatus.BAD_REQUEST, "IMPORT_FAILURE", "导入失败"),
    SUPERADMIN_NOT_ALLOWED_MODIFY(HttpStatus.BAD_REQUEST, "SUPERADMIN_NOT_ALLOWED_MODIFY", "不允许删除超级管理员用户"),

    //导出数据
    EXPORT_EXCEL_FAILURE(HttpStatus.BAD_REQUEST, "EXPORT_EXCEL_FAILURE", "导出Excel失败，请联系网站管理员"),

    FileSizeLimit(HttpStatus.BAD_REQUEST, "FileSizeLimitExceededException", "文件超出最大限制大小"),
    FileNameLengthLimit(HttpStatus.BAD_REQUEST, "FileNameLengthLimitExceededException", "文件名字超出最大限制大小"),
    ReadFileFaile(HttpStatus.BAD_REQUEST, "ReadFileFaileException", "读取文件失败"),
    INVALID_FILE_NAME(HttpStatus.BAD_REQUEST, "FILENAME_INVALID", "文件名称非法，不允许下载"),

    CAPTCHA_ERROR(HttpStatus.BAD_REQUEST, "CAPTCHA_ERROR", "生成图片验证码失败"),

    IP_ERROR(HttpStatus.BAD_REQUEST, "IP_ERROR", "输入的ip格式错误"),
    FORBIDDEN_IP(HttpStatus.FORBIDDEN, "FORBIDDEN_IP", "该请求ip不允许访问"),
    FORBIDDEN_USER_ACCESS(HttpStatus.FORBIDDEN, "FORBIDDEN_USER_ACCESS", "该用户不允许访问"),
    FORBIDDEN_USER_LOGIN(HttpStatus.FORBIDDEN, "FORBIDDEN_USER_LOGIN", "该用户不允许登陆"),
    SMS_CODE_NOT_OPEN(HttpStatus.FORBIDDEN, "SMS_CODE_NOT_OPEN", "短信验证码未开启"),
    AUTH_UNAVAILABLE_TOKEN_SECOND_LOGIN(HttpStatus.UNAUTHORIZED, "AUTH_UNAVAILABLE_TOKEN_SECOND_LOGIN", "不可用授权令牌,请重新登陆"),

    //应用信息
    APP_NOT_EXIST(HttpStatus.BAD_REQUEST, "APP_NOT_EXIST", "应用不存在");


    private HttpStatus httpStatus;
    private String code;
    private String message;

    ErrorCode(HttpStatus httpStatus, String code, String message) {
        setHttpStatus(httpStatus);
        setCode(code);
        setMessage(message);
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
