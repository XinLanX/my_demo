package com.xxl.myoracle.keysequence.domain;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName(value ="dev_application")
@KeySequence(value = "SEQ_DEV_APPLICATION",clazz = Integer.class)
public class DevApplication implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 表ID */
    @TableId(value = "ID",type = IdType.INPUT)
    private Integer id;
    /** 应用编码 */
    @TableField(value = "app_code")
    private String appCode;
    /** 应用名称 */
    @TableField(value = "app_name")
    private String appName;
    /** 项目ID */
    @TableField(value = "project_id")
    private Integer projectId;
    /** 应用地址 */
    @TableField(value = "app_url")
    private String appUrl;
    /** 是否为用户中心 */
    @TableField(value = "is_uc")
    private String isUc;
    /** 应用状态 */
    @TableField(value = "status")
    private String status;
    /** 应用描述 */
    @TableField(value = "app_comment")
    private String appComment;
    /** 初始化状态 */
    @TableField(value = "init_status")
    private String initStatus;
    /** 创建人 */
    @TableField(value = "create_by")
    private String createBy;
    /** 创建时间 */
    @TableField(value = "create_time")
    private Date createTime;
    /** 成员 */
    @TableField(value = "app_members")
    private String appMembers;
    /** GIT上应用ID */
    @TableField(value = "git_type_id")
    private Integer gitTypeId;
    /** GIT应用ID类型 */
    @ApiModelProperty(value="应用地址")
    @TableField(value = "git_type")
    private String gitType;
    /** 应用权限 */
    @TableField(exist = false)
    private Integer userId;
}
