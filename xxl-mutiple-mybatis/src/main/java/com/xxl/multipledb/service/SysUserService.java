package com.xxl.multipledb.service;

import com.xxl.multipledb.entity.SysUser;
import com.xxl.multipledb.service.impl.SysUserServiceImpl;

import java.util.List;

public interface SysUserService {
    List<SysUser> sysUserList();

    List<SysUser> sysUserList1();
}
