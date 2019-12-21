package com.czxy.paopao.controller;

import com.czxy.paopao.commons.dto.CommonsCode;
import com.czxy.paopao.commons.dto.ResponseResult;
import com.czxy.paopao.commons.dto.xs.XsInfo;
import com.czxy.paopao.commons.dto.xs.reqPage;
import com.czxy.paopao.domain.PpXuanshang;
import com.czxy.paopao.service.XsService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by dell on 2019/12/9.
 *
 * @author zbdshh
 * @date 2019/12/9
 */
@RestController
@RequestMapping("/xuanshang")
public class XsController {
@Resource
    private XsService service;

//新增悬赏
@PostMapping("/insert")
    public ResponseEntity<ResponseResult<PpXuanshang>> insert(@RequestBody XsInfo info){
  ResponseResult  br= null;
    PpXuanshang xs = new PpXuanshang();

    BeanUtils.copyProperties(info,xs);
    try {
        service.insert(xs);
       br= new ResponseResult<>(CommonsCode.ok,"新增成功");
    } catch (Exception e) {
        br = new ResponseResult<>(CommonsCode.error,"新增失败");
    }
   return  ResponseEntity.ok(br);
}
//删除悬赏
    @PutMapping("/user_edit")
    public ResponseEntity<ResponseResult<PpXuanshang>> remove(@RequestBody XsInfo info){
        ResponseResult  br= null;
        try {
            service.remove(info);
            br= new ResponseResult<>(CommonsCode.ok,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            br = new ResponseResult<>(CommonsCode.error,"删除失败");
        }
        return  ResponseEntity.ok(br);
    }
    //接单后的第一个状态改变
    @PutMapping("/order_edit")
    public ResponseEntity<ResponseResult<PpXuanshang>> OrderStart_edit(@RequestBody XsInfo info){
        ResponseResult  br= null;
        try {
            service.OrderStart_edit(info);
            br= new ResponseResult<>(CommonsCode.ok,"订单接取成功");
        } catch (Exception e) {
            e.printStackTrace();
            br= new ResponseResult<>(CommonsCode.error,"订单接取失败");
        }
        return ResponseEntity.ok(br);
    }
    //订单完成后的状态
    @PutMapping("/order_over")
    public ResponseEntity<ResponseResult<PpXuanshang>> OrderOver_edit(@RequestBody XsInfo info){
        ResponseResult  br= null;
        try {
            service.OrderOver_edit(info);
            br= new ResponseResult<>(CommonsCode.ok,"提交成功");
        } catch (Exception e) {
            e.printStackTrace();
            br= new ResponseResult<>(CommonsCode.error,"提交失败");
        }
        return ResponseEntity.ok(br);
    }
    //查询
@GetMapping("/getPage")
    public  ResponseEntity<ResponseResult> getAll(reqPage page){
    PageInfo<PpXuanshang> pageInfo = service.getPage(page);
    ResponseResult<PageInfo<PpXuanshang>> br = new ResponseResult<>(CommonsCode.ok, "ok", pageInfo);
    return  ResponseEntity.ok(br);
}
}
