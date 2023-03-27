package com.xxl.multipledb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxl.multipledb.entity.SysUser;

import java.util.List;

public interface SysUserDao extends BaseMapper<SysUser> {
    List<SysUser> sysUserList();
}
