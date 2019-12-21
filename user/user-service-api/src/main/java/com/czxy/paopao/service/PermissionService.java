package com.czxy.paopao.service;

import com.czxy.paopao.commons.dto.ResponseResult;

public interface PermissionService {

    ResponseResult selectByUserId(String id);

    ResponseResult selectByUserPhone(String phone);

}
