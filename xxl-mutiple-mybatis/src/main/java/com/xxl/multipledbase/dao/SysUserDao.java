package com.xxl.multipledbase.dao;

import com.xxl.multipledbase.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserDao {
    List<SysUser> sysUserList();
}
