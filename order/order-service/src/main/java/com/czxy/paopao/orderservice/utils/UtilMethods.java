package com.czxy.paopao.orderservice.utils;

import org.springframework.stereotype.Component;

/**
 * Created 路程很长 请别轻易失望 on 2019/12/9.
 *
 * @author Keep On Running
 */
@Component
public class UtilMethods {
    /**
     *   获取登录中的用户ID
     * @return 用户ID
     */
    public String getUserId(){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        return authentication.getName();
        return null;
    }
}
