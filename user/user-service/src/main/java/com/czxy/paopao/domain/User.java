package com.czxy.paopao.domain;

import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "pp_user")
public class User {
    /**
     * UUID
     */
    @Column(name = "user_id")
    private String userId;

    @Column(name = "phone")
    private String phone;

    @Column(name = "passowrd")
    private String passowrd;

    /**
     * 性别
     */
    @Column(name = "gender")
    private String gender;

    /**
     * 昵称
     */
    @Column(name = "nickname")
    private String nickname;

    /**
     * 真实身份关联键
     */
    @Column(name = "real_id")
    private String realId;

    /**
     * 头像
     */
    @Column(name = "head_photo")
    private String headPhoto;
}