package com.czxy.paopao.commons.dto.xs;

/**
 * Created by dell on 2019/12/9.
 *
 * @author zbdshh
 * @date 2019/12/9
 */
public class reqPage {
    private  Integer page;
    private  Integer size;
    private  String key; //目前是key 后期改

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
