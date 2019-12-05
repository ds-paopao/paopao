package com.czxy.paopao.interceptor;

import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.Charset;
import java.util.Enumeration;

public class FeignRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        //获取请求头参数
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();

        //设置RequestTemplate头
        Enumeration<String> headerNames = request.getHeaderNames();
      if (headerNames != null){
          while (headerNames.hasMoreElements()){
              String name = headerNames.nextElement();
              String header = request.getHeader(name);
              requestTemplate.header(name,header);
          }
      }

        // 设置请求体，这里主要是为了传递 access_token

        Enumeration<String> parameterNames = request.getParameterNames();
      StringBuilder body = new StringBuilder();
        if (parameterNames!=null){
            while (parameterNames.hasMoreElements()){
                String name = parameterNames.nextElement();
                String value = request.getParameter(name);

                if ("access_token".equals(name)){
                    requestTemplate.header(name,value);
                }else {
                    body.append(name)
                        .append("=")
                        .append(value)
                        .append("&");
                }
            }
        }

        if (body.length() > 0){
            body.deleteCharAt(body.length() - 1);
            requestTemplate.body(Request.Body.bodyTemplate(body.toString(),Charset.defaultCharset()));
        }
    }
}
