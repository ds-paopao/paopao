package com.czxy.paopao.domain;

import lombok.Data;

@Data
public class User {
    /**
     * UUID
     */
    private String userId;

    private String phone;

    private String passowrd;

    /**
     * 性别
     */
    private String gender;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 真实身份关联键
     */
    private String realId;

    /**
     * 头像
     */
    private String headPhoto;
}