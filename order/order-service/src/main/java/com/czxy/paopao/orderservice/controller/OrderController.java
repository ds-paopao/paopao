package com.czxy.paopao.orderservice.controller;

import com.czxy.paopao.commons.dto.OrderInfo;
import com.czxy.paopao.commons.dto.ResponseResult;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created 路程很长 请别轻易失望 on 2019/12/5.
 *
 * @author Keep On Running
 *
 * 测试一下上传
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    /**
     * 下单
     * 说明:点击接单时调用此接口,传入悬赏id,用户id
     *     必选参数:	xs_id(悬赏id)
     *     请求类型:	post
     *     接口地址:	/order/placeAnOrder
     *     调用例子 : 	/order/placeAnOrder
     * @return
     */
    @PostMapping
    public ResponseResult responseResult(@RequestBody OrderInfo orderInfo) {
        // todo 在此处获取 用户 信息    拼接成订单添加到
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 获取个人信息
        return new ResponseResult(1, "hha");
    }
}
