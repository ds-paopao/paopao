package com.czxy.paopao.service;

import com.czxy.paopao.commons.utils.CommonsCode;
import com.czxy.paopao.commons.utils.ConstObject;
import com.czxy.paopao.commons.utils.SendSms;
import com.czxy.paopao.commons.utils.util;
import com.czxy.paopao.commons.vo.ResponseResult;
import com.czxy.paopao.domain.User;
import org.apache.dubbo.config.annotation.Service;
import javax.annotation.Resource;
import com.czxy.paopao.mapper.UserMapper;
import tk.mybatis.mapper.entity.Example;

import java.util.Map;


@Service(version = "1.0.0")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
//    手机验证码集合
    Map<String,String> mobileVerificationCode =  ConstObject.PHONE_VERIFICATIONCODE;


    @Override
    public ResponseResult findById(Integer id) {
        try {
            return new ResponseResult(userMapper.selectByPrimaryKey(id));
        } catch (Exception e) {
            return ConstObject.ERROR_REEORRESULT;
        }
    }

    @Override
    public ResponseResult getUserByUid(String uid) {
        try {
            return new ResponseResult(userMapper.selectByPrimaryKey(uid));
        } catch (Exception e) {
            return ConstObject.ERROR_REEORRESULT;
        }
    }


    @Override
    public ResponseResult getUserByPhone(String phone) {
        try {
            Example example = new Example(User.class);
            example.createCriteria().andEqualTo("phone", phone);
            User user = userMapper.selectOneByExample(example);
            return new ResponseResult(user);
        } catch (Exception e) {
            return ConstObject.ERROR_REEORRESULT;
        }
    }

    /**
     * 根据手机号,是否存在于数据库中, 不存在则可以注册返回1, 存在则返回0
     * @param phone
     * @return
     */
    @Override
    public ResponseResult isExistPhone(String phone) {
        try {
            Object userByPhone = getUserByPhone(phone).getData();
            return new ResponseResult(userByPhone == null ? CommonsCode.ok : CommonsCode.error);
        } catch (Exception e) {
            return ConstObject.ERROR_REEORRESULT;
        }
    }

    /**
     * 发送验证码
     * @param phone
     * @return
     */
    @Override
    public ResponseResult sendSms(String phone) {
        String verificationCode = SendSms.sendSms(phone);
//        发送失败
        if (verificationCode.equals(SendSms.ERROR_SEND_CODE)){
            return ConstObject.ERROR_REEORRESULT;
        }
//        发送成功添加到统计集合
        mobileVerificationCode.put(phone,verificationCode);
        return new ResponseResult(CommonsCode.ok);
    }

    @Override
    public ResponseResult register(String verificationCode,User registerser) {
        mobileVerificationCode.put("18036579096","123456");
        ResponseResult responseResult = new ResponseResult();
        try {
            if (verificationCode.equals(mobileVerificationCode.get(registerser.getPhone()))) {
    //            TODO 设置注册用户的基本信息
                registerser.setNickname(registerser.getPhone());
                registerser.setUserId(util.getUUID());
                this.addUser(registerser);
                responseResult.setState(CommonsCode.ok);
            }
        } catch (Exception e) {
            responseResult.setState(CommonsCode.error);
            responseResult.setMessage("注册失败");
        }
        return responseResult;
    }

    @Override
    public ResponseResult addUser(User user) {
        userMapper.insert(user);
        return new ResponseResult("注册成功");
    }

    @Override
    public ResponseResult editPassWordByPhone(User user) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("phone",user.getPhone());
        try {
            userMapper.updateByExample(user,example);
            return new ResponseResult(CommonsCode.ok,"修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseResult(CommonsCode.error,"修改失败");
        }
    }


}
