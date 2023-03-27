package com.xxl.myoracle.keysequence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxl.myoracle.keysequence.domain.DevApplication;
import com.xxl.myoracle.keysequence.mapper.DevApplicationMapper;
import com.xxl.myoracle.keysequence.service.IDevApplicationService;
import org.springframework.stereotype.Service;

@Service
public class DevApplicationServiceImpl extends ServiceImpl<DevApplicationMapper, DevApplication> implements IDevApplicationService {
}
