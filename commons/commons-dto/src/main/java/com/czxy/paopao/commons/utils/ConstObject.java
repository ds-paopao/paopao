package com.czxy.paopao.commons.utils;

import com.czxy.paopao.commons.vo.ResponseResult;

import java.util.HashMap;
import java.util.Map;

public interface ConstObject {
    /** 出现错误的返回对象*/
    ResponseResult ERROR_REEORRESULT = new ResponseResult(CommonsCode.error, "网络异常~");
    /** 用于存储手机注册时的验证码 */
    Map PHONE_VERIFICATIONCODE = new HashMap<String,String>();

}
