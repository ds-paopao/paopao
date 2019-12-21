package com.czxy.paopao.service;

import com.czxy.paopao.commons.vo.ResponseResult;

public interface PermissionService {

    ResponseResult selectByUserId(String id);

    ResponseResult selectByUserPhone(String phone);

}
