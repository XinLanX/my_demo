package com.xxl.multipledb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxl.multipledb.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SysUserDao extends BaseMapper<SysUser> {
    List<SysUser> sysUserList();
}
