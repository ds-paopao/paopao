package com.czxy.paopao.orderservice.controller;

import com.czxy.paopao.commons.dto.ResponseResult;
import com.czxy.paopao.commons.dto.order.OrderInfo;
import com.czxy.paopao.orderservice.domain.PpOrder;
import com.czxy.paopao.orderservice.service.PpOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created 路程很长 请别轻易失望 on 2019/12/5.
 *
 * @author Keep On Running
 * <p>
 * 测试一下上传
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private PpOrderService ppOrderService;

    /**
     * 下单
     * 说明:点击接单时调用此接口,传入悬赏id,用户id
     * 必选参数:	xs_id(悬赏id)
     * 请求类型:	post
     * 接口地址:	/order/placeAnOrder
     * 调用例子 : 	/order/placeAnOrder
     *
     * @return ResponseResult
     */
    @PostMapping("/placeAnOrder")
    public ResponseResult placeAnOrder(@RequestBody OrderInfo orderInfo) {
        System.out.println(11);
        // todo 在此处获取 用户 信息    拼接成订单添加到
       /* Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 获取个人信息   根据约定这个就是接单人id
        String lansquenet = authentication.getName();*/
        PpOrder ppOrder = new PpOrder(orderInfo.getXsId(), "奥术大师", 1, 1, 1, new Date());

        ppOrder.setOid("6424f0e6-4d37-4846-9a09-c47c00e6d39d");
        int i = ppOrderService.placeAnOrder(ppOrder);
        return new ResponseResult(ResponseResult.CodeStatus.OK, "接单成功");
    }
}
