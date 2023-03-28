package com.xxl.multipledb.service.impl;

import com.xxl.multipledb.dao.SysUserDao;
import com.xxl.multipledb.entity.SysUser;
import com.xxl.multipledb.service.SysUserService;
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
    public List<SysUser> sysUserList1(){
        return sysUserDao.sysUserList();
    }
}
