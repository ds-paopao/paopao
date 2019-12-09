package com.czxy.paopao.orderservice.service;

import com.czxy.paopao.orderservice.dao.PpOrderMapper;
import com.czxy.paopao.orderservice.domain.PpOrder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created 路程很长 请别轻易失望 on 2019/12/5.
 *
 * @author Keep On Running
 */
@Service
public class PpOrderService {

    @Resource
    private PpOrderMapper ppOrderMapper;

    public int placeAnOrder(PpOrder ppOrder) {
        return ppOrderMapper.insertSelective(ppOrder);
    }

    public PpOrder selectOneOrderByPrimaryKey(String oid) {
        return ppOrderMapper.selectByPrimaryKey(oid);
    }

    public int editOrder(PpOrder ppOrder) {
        return ppOrderMapper.updateByPrimaryKeySelective(ppOrder);
    }

/*    public List<PpOrder> getAllOrder(OrderRequestSearchInfo orderRequestSearchInfo) {
        PageHelper.startPage(orderRequestSearchInfo.getPageNum(),orderRequestSearchInfo.getPageSize());


    }*/
}
