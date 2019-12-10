package com.czxy.paopao.service;

import com.czxy.paopao.commons.dto.xs.XsInfo;
import com.czxy.paopao.commons.dto.xs.reqPage;
import com.czxy.paopao.dao.XsMapper;
import com.czxy.paopao.domain.PpXuanshang;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

/**
 * Created by dell on 2019/12/9.
 *
 * @author zbdshh
 * @date 2019/12/9
 */
@Service
public class XsService {
@Resource
    private XsMapper  mapper;

    public void insert(PpXuanshang xs) {
      //悬赏id
        xs.setXsId(UUID.randomUUID()+"");
        System.out.println(new Date());
        //发布时间
        xs.setCreateTime(new Date());
        //状态码
        xs.setState(1);
        mapper.insert(xs);
    }

    public void remove(XsInfo info) {
        PpXuanshang xuanshang = mapper.selectByPrimaryKey(info.getXsId());
        //禁用
        xuanshang.setState(0);
    mapper.updateByPrimaryKeySelective(xuanshang);
    }

    public void OrderStart_edit(XsInfo info) {
        PpXuanshang xuanshang = mapper.selectByPrimaryKey(info.getXsId());
        //正在进行
        xuanshang.setState(2);
        mapper.updateByPrimaryKeySelective(xuanshang);
    }

    public void OrderOver_edit(XsInfo info) {
        PpXuanshang xuanshang = mapper.selectByPrimaryKey(info.getXsId());
        //悬赏完成
        xuanshang.setState(3);
        mapper.updateByPrimaryKeySelective(xuanshang);
    }

    public PageInfo<PpXuanshang> getPage(reqPage page) {
        PageHelper.startPage(page.getPage(),page.getSize());
        PageInfo<PpXuanshang> info = new PageInfo<>(mapper.selectAll());
        return info;
    }
}
