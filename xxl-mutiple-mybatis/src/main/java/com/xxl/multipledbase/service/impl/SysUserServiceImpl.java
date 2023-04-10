package com.xxl.multipledbase.service.impl;

import com.xxl.multipledbase.dao.SysUserDao;
import com.xxl.multipledbase.entity.SysUser;
import com.xxl.multipledbase.handler.DataSource;
import com.xxl.multipledbase.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public List<SysUser> sysUserList(){
        return sysUserDao.sysUserList();
    }

    @Override
    @DataSource("db2")
    public List<SysUser> sysUserList1(){
        return sysUserDao.sysUserList();
    }
}
