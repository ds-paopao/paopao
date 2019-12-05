package com.czxy.paopao.orderservice.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

        /**
         * Created 路程很长 请别轻易失望 on 2019/12/5.  
         * @author Keep On Running
         */
@Data
@Table(name = "pp_order")
public class PpOrder {
    /**
     * 订单id

     */
    @Column(name = "oid")
    private String oid;

    /**
     * 悬赏id
     */
    @Column(name = "xs_id")
    private String xsId;

    /**
     * 接单人

     */
    @Column(name = "lansquenet")
    private String lansquenet;

    /**
     * 状态码
	0-取消订单
	1-进行中
	2-完成任务代交付
	3-已完结
     */
    @Column(name = "`state`")
    private Integer state;

    /**
     * 发单人是否显示
	0-删除
	1-显示
     */
    @Column(name = "show_one")
    private Integer showOne;

    /**
     * 接单人是否删除
	0-删除
	1-显示
     */
    @Column(name = "show_two")
    private Integer showTwo;

    /**
     * 接单时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 接单时间
     */
    @Column(name = "end_time")
    private Date endTime;
}