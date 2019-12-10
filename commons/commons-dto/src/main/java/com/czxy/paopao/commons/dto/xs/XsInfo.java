package com.czxy.paopao.commons.dto.xs;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by dell on 2019/12/9.
 *
 * @author zbdshh
 * @date 2019/12/9
 */
public class XsInfo {
    private  String xsId;
    private  String brief;
    private  String context;
    private  Double price;

    private Date    createTime;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date    endTime;
    private  Integer state;
    private  String uid;
    private  String address;

    public String getXsId() {
        return xsId;
    }

    public void setXsId(String xsId) {
        this.xsId = xsId;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
