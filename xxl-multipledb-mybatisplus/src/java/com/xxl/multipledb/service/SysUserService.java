package com.xxl.multipledb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxl.multipledb.entity.SysUser;
import com.xxl.multipledb.service.impl.SysUserServiceImpl;

import java.util.List;

public interface SysUserService extends IService<SysUser> {
    List<SysUser> sysUserList();

    List<SysUser> sysUserList1();
}
