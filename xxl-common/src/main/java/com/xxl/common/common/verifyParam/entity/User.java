package com.xxl.common.common.verifyParam.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class User {
    @NotBlank(message = "用户姓名不能为空")
    String name;

    @NotBlank(message = "用户身份证号不能为空")
    String idCardNo;
}
