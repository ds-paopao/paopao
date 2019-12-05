package com.czxy.paopao.orderservice.controller;

import com.czxy.paopao.commons.dto.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
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
    @GetMapping
    public ResponseResult responseResult(){
     return new ResponseResult(1,"hha");
    }
}
