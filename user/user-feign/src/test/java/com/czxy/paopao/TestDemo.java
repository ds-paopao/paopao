package com.czxy.paopao;

import com.czxy.paopao.domain.User;
import com.czxy.paopao.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootTest
@RunWith(SpringRunner.class)
public class TestDemo {

/*    @Reference(version = "1.0.0")
    private UserService service;

    @Test
    public void tes(){
        User byId = service.findById(1);
        System.out.println(byId);
    }*/

    @Test
    public void tes2(){
        System.out.println(new BCryptPasswordEncoder().encode("456789"));
//        String hkzl = new BCryptPasswordEncoder().encode("secret");
//        System.out.println(hkzl);
    }

}
