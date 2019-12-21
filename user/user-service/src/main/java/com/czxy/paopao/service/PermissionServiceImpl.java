package com.czxy.paopao.service;


import com.czxy.paopao.commons.utils.CommonsCode;
import com.czxy.paopao.commons.vo.ResponseResult;
import com.czxy.paopao.mapper.PermissionMapper;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

@Service(version = "1.0.0")
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionMapper ppPermissionMapper;

    @Override
    public ResponseResult selectByUserId(String id) {
        return new ResponseResult(ppPermissionMapper.selectByUserId(id));
    }

    @Override
    public ResponseResult selectByUserPhone(String phone) {
        return new ResponseResult(ppPermissionMapper.selectByUserPhone(phone));
    }
}
