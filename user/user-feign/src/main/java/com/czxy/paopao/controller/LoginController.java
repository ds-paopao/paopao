package com.czxy.paopao.controller;

import com.czxy.paopao.commons.dto.LoginInfo;
import com.czxy.paopao.commons.dto.LoginParam;
import com.czxy.paopao.commons.vo.ResponseResult;
import com.google.common.collect.Maps;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;

/**
 * 登录管理
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class LoginController {
    private static final String URL_OAUTH_TOKEN = "http://localhost:9001/oauth/token";

    @Value("${business.oauth2.grant_type}")
    public String oauth2GrantType;
    @Value("${business.oauth2.client_id}")
    public String oauth2ClientId;
    @Value("${business.oauth2.client_secret}")
    public String oauth2ClientSecret;
    @Resource(name = "userDetailsServiceBean")
    public UserDetailsService userDetailsService;
    @Resource
    public BCryptPasswordEncoder passwordEncoder;
    @Resource
    public TokenStore tokenStore;

    /**
     * 登录
     *
     * @param loginParam 登录参数
     * @return {@link ResponseResult}
     */
    @PostMapping(value = "/user/login")
    public ResponseResult<Map<String, Object>> login(@RequestBody LoginParam loginParam) {
        // 封装返回的结果集
        Map<String, Object> result = Maps.newHashMap();
        // 验证密码是否正确
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginParam.getUsername());
        if (userDetails == null || !passwordEncoder.matches(loginParam.getPassword(), userDetails.getPassword())) {
            return new ResponseResult<Map<String, Object>>(ResponseResult.CodeStatus.ILLEGAL_REQUEST, "账号或密码错误", null);
        }
        // 通过 HTTP 客户端请求登录接口
        Map<String, String> params = Maps.newHashMap();
        params.put("username", loginParam.getUsername());
        params.put("password", loginParam.getPassword());
        params.put("grant_type", oauth2GrantType);
        params.put("client_id", oauth2ClientId);
        params.put("client_secret", oauth2ClientSecret);
        try {
            // 解析响应结果封装并返回
            Response response = OkHttpClientUtil.getInstance().postData(URL_OAUTH_TOKEN, params);
            String jsonString = Objects.requireNonNull(response.body()).string();
            Map<String, Object> jsonMap = MapperUtils.json2map(jsonString);
            String token = String.valueOf(jsonMap.get("access_token"));
            result.put("token", token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseResult<Map<String, Object>>(ResponseResult.CodeStatus.OK, "登录成功", result);
    }

    /**
     * 获取用户信息
     *
     * @return {@link ResponseResult}
     */
    @GetMapping(value = "/user/info")
    public ResponseResult<LoginInfo> info(HttpServletRequest request) {
        // 获取 token
        String token = request.getParameter("access_token");
        // 获取认证信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 封装并返回结果
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setName(authentication.getName());
        loginInfo.setAvatar("");
        loginInfo.setToken(token);
        return new ResponseResult<LoginInfo>(ResponseResult.CodeStatus.OK, "获取用户信息", loginInfo);
    }

    /**
     * 注销
     *
     * @return {@link ResponseResult}
     */
    @PostMapping(value = "/user/logout")
    public ResponseResult<Void> logout(HttpServletRequest request) {
        // 获取 token
        String token = request.getParameter("access_token");
        // 删除 token 以注销
        OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(token);
        tokenStore.removeAccessToken(oAuth2AccessToken);
        return new ResponseResult<Void>(ResponseResult.CodeStatus.OK, "用户已注销");
    }
}