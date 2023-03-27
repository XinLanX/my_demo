package com.xxl.myoracle.keysequence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxl.myoracle.keysequence.domain.DevApplication;

import java.util.List;

public interface DevApplicationMapper extends BaseMapper<DevApplication> {
    public List<DevApplication> selectDevApp();
}
