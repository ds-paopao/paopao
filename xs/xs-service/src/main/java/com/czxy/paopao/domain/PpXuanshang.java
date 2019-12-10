package com.czxy.paopao.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by dell on 2019/12/9.
 *
 * @author zbdshh
 * @date 2019/12/9
 */
@Table(name = "pp_xuanshang")
public class PpXuanshang {
@Id
    @Column(name = "xs_id")
    private  String xsId;
    @Column(name = "brief")
    private  String brief;
    @Column(name = "context")
    private  String context;
    @Column(name = "price")
    private  Double price;
    @DateTimeFormat(pattern = "yyyy-MM-dd-HH-mm")
    @JsonFormat(pattern="yyyy-MM-dd-HH-mm",timezone="GMT+8")
    @Column(name = "create_time")
    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd-HH-mm")
    @JsonFormat(pattern="yyyy-MM-dd-HH-mm",timezone="GMT+8")
    @Column(name = "end_time")
    private Date    endTime;
    @Column(name = "state")
    private  Integer state;
    @Column(name = "uid")
    private  String uid;
    @Column(name = "address")
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

    @Override
    public String toString() {
        return "PpXuanshang{" +
                "xsId='" + xsId + '\'' +
                ", brief='" + brief + '\'' +
                ", context='" + context + '\'' +
                ", price=" + price +
                ", createTime=" + createTime +
                ", endTime=" + endTime +
                ", state=" + state +
                ", uid='" + uid + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
