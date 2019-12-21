package com.czxy.paopao.commons.utils;

import java.util.UUID;

public class util {

    /**
     * 生成6位数验证码
     * @return 验证码
     */
    public static String smsCode(){
        return (int)((Math.random()*9+1)*100000)+"";
    }

    public static String getUUID(){
        return UUID.randomUUID().toString();
    }
}
