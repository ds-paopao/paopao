package com.czxy.paopao.api;

import com.czxy.paopao.commons.dto.order.OrderInfo;
import com.czxy.paopao.interceptor.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created 路程很长 请别轻易失望 on 2019/12/9.
 *
 * @author Keep On Running
 */
@FeignClient(value = "pp-order", path = "user", configuration = FeignRequestConfiguration.class)
public interface OrderFeign{
    @PostMapping("/placeAnOrder")
    String placeAnOrder(@RequestBody OrderInfo orderInfo);

    @DeleteMapping("/delOrder/{oid}")
    String delOrder(@PathVariable Integer oid);
}
