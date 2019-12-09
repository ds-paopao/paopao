package com.czxy.paopao.commons.dto.order;

import lombok.Data;

/**
 * Created 路程很长 请别轻易失望 on 2019/12/9.
 *
 * @author Keep On Running
 */
@Data
public class OrderRequestSearchInfo {
    /**
     * 第几页
     */
    private Integer pageNum;
    /**
     * 一页几条数据
     */
    private Integer pageSize;
    /**
     * 搜索关键字
     */
    private String searchKey;
}
