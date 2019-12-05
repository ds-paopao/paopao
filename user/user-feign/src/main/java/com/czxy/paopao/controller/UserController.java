package com.czxy.paopao.controller;

import com.czxy.paopao.commons.dto.CommonsCode;
import com.czxy.paopao.commons.dto.ResponseResult;
import com.czxy.paopao.domain.User;
import com.czxy.paopao.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user")
public class UserController {

    @Reference(version = "1.0.0")
    private UserService service;

    @GetMapping("/login")
    public ResponseEntity<ResponseResult> findByUid(@PathVariable Integer id){
        User byId = service.findById(1);
        return ResponseEntity.ok(new ResponseResult(CommonsCode.ok,"成功",byId));
    }

}
