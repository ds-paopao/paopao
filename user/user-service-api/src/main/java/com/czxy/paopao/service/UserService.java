package com.czxy.paopao.service;

import com.czxy.paopao.commons.dto.ResponseResult;
import com.czxy.paopao.domain.User;

public interface UserService {

    ResponseResult findById(Integer id);

    ResponseResult getUserByUid(String uid);

    ResponseResult getUserByPhone(String phone);

    ResponseResult isExistPhone(String phone);

    ResponseResult sendSms(String phone);

    ResponseResult register(String verificationCode , User register);

    ResponseResult addUser(User user);

    ResponseResult editPassWordByPhone(User user);



}
