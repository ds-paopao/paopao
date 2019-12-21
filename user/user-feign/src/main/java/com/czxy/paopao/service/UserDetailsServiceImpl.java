package com.czxy.paopao.service;

import com.google.common.collect.Lists;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import java.util.List;
// 优化了认证逻辑
@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "$2a$10$YNUV/BtCel2orbhgrxyPJeljdKVty6yTAL.Cj4v3XhwHWXBkgyPYW";
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // 用户名匹配
        if (s.equals(USERNAME)) {
            List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("USER");
            grantedAuthorities.add(grantedAuthority);
            return new User(USERNAME, PASSWORD, grantedAuthorities);
        }
        // 用户名不匹配
        else {
            return null;
        }
    }
}