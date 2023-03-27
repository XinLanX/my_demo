package com.xxl.multipledb.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxl.multipledb.dao.SysUserDao;
import com.xxl.multipledb.entity.SysUser;
import com.xxl.multipledb.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements SysUserService {
    @Autowired
    private SysUserDao sysUserDao;

    @DS("master")
    @Override
    public List<SysUser> sysUserList(){
        return sysUserDao.sysUserList();
    }

    @DS("db2")
    @Override
    public List<SysUser> sysUserList1(){
        return sysUserDao.sysUserList();
    }
}
