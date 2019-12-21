package com.czxy.paopao.controller;

import com.czxy.paopao.commons.vo.ResponseResult;
import com.czxy.paopao.domain.User;
import com.czxy.paopao.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {

    @Reference(version = "1.0.0")
    private UserService userService;


    @GetMapping("/base/{id}")
    public ResponseResult getUserByUid(@PathVariable("id") String id) {
        return userService.getUserByUid(id); }

    @GetMapping("/isexist/{phone}")
    public ResponseResult isExistPhone(@PathVariable("phone") String phone) {
        return userService.isExistPhone(phone);
    }

    @GetMapping("/sendsms/{phone}")
    public ResponseResult sendSms(@PathVariable("phone") String phone) {
        return userService.sendSms(phone);
    }

    @PostMapping("/register/{verificationCode}")
    public ResponseResult registered(@PathVariable("verificationCode") String verificationCode, @RequestBody User user) {
        return userService.register(verificationCode, user); }

    @PostMapping("/user/editpass")
    public ResponseResult editPassWordByPhone(@RequestBody User user) {
        return userService.editPassWordByPhone(user); }


}
