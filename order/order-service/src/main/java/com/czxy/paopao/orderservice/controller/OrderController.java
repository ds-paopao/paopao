package com.czxy.paopao.orderservice.controller;

import com.czxy.paopao.commons.dto.ResponseResult;
import com.czxy.paopao.commons.dto.order.OrderInfo;
import com.czxy.paopao.orderservice.domain.PpOrder;
import com.czxy.paopao.orderservice.service.PpOrderService;
import com.czxy.paopao.orderservice.utils.UtilMethods;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

/**
 * Created 路程很长 请别轻易失望 on 2019/12/5.
 *
 * @author Keep On Running
 * <p>
 * 测试一下上传
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    private UtilMethods utilMethods;
    @Resource
    private PpOrderService ppOrderService;

    /**
     * 下单
     * 说明:点击接单时调用此接口,传入悬赏id,用户id
     * 必选参数:	xs_id(悬赏id)
     * 请求类型:	post
     * 接口地址:	/order/placeAnOrder
     * 调用例子 : 	/order/placeAnOrder
     *
     * @return ResponseResult
     */
    @PostMapping("/placeAnOrder")
    public ResponseResult placeAnOrder(@RequestBody OrderInfo orderInfo) {
        //获取接单人Id
//        String lansquenet = utilMethods.getUserId();
        PpOrder ppOrder = new PpOrder(orderInfo.getXsId(), "奥术大师", 1, 1, 1, new Date());
        ppOrder.setOid(UUID.randomUUID().toString());
        int i = ppOrderService.placeAnOrder(ppOrder);
        return new ResponseResult(ResponseResult.CodeStatus.OK, "接单成功");
    }

    /**
     * 说明:用户查看自己历史订单时,不想看到某条记录,点击删除时触发该接口
     * 必选参数:	oid(订单id)
     * 请求类型:	delete
     * 接口地址:	/order/delOrder
     * 调用例子:	/order/delOrder/oid=1
     */
    @DeleteMapping("/delOrder/{oid}")
    public ResponseResult delOrder(@PathVariable String oid){
        // 通过ID查找订单记录
        PpOrder ppOrder = ppOrderService.selectOneOrderByPrimaryKey(oid);
        // 如果接单人ID 匹配上了证明是接单人在删除  将show_two状态改成0即可   反之亦然
        if (ppOrder.getLansquenet().equals("奥术大师")) {
            ppOrder.setShowTwo(0);
        }else {
            ppOrder.setShowTwo(1);
        }
        // 修改
        int i = ppOrderService.editOrder(ppOrder);
        //返回结果
        if (i>0){
            return new ResponseResult(ResponseResult.CodeStatus.OK, "删除成功");
        }else {
            return new ResponseResult(ResponseResult.CodeStatus.OK, "网络错误");
        }
    }

    /**
     * 说明:查询所有订单分页显示,按时间降序排列
     * 必选参数:	pageNum(第几页),pageSize(一页几条)
     * 可选参数: 	searchKey(关键字)
     * 请求类型:	get
     * 接口地址:	/order/getAllOrder
     * 调用例子:	/order/getAllOrder/pageNum=1&pageSize=5&searchKey=水
     */
/*    @GetMapping
    public ResponseResult getAllOrder(OrderRequestSearchInfo orderRequestSearchInfo){
        List<PpOrder> dbOrder = ppOrderService.getAllOrder(orderRequestSearchInfo);
    }*/


}
