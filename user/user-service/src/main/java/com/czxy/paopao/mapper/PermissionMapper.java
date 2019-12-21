package com.czxy.paopao.mapper;


import com.czxy.paopao.domain.Permission;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PermissionMapper extends Mapper<Permission> {

    @Select(" SELECT\n" +
            "            p.*\n" +
            "        FROM\n" +
            "            pp_user AS u\n" +
            "                LEFT JOIN pp_user_role AS ur\n" +
            "                          ON u.user_id = ur.user_id\n" +
            "                LEFT JOIN pp_role AS r\n" +
            "                          ON r.id = ur.role_id\n" +
            "                LEFT JOIN pp_role_permission AS rp\n" +
            "                          ON r.id = rp.role_id\n" +
            "                LEFT JOIN pp_permission AS p\n" +
            "                          ON p.id = rp.permission_id\n" +
            "        WHERE u.id = #{id}")
    List<Permission> selectByUserId(@Param("id") String id);

    @Select(" SELECT\n" +
            "            p.*\n" +
            "        FROM\n" +
            "            pp_user AS u\n" +
            "                LEFT JOIN pp_user_role AS ur\n" +
            "                          ON u.user_id = ur.user_id\n" +
            "                LEFT JOIN pp_role AS r\n" +
            "                          ON r.id = ur.role_id\n" +
            "                LEFT JOIN pp_role_permission AS rp\n" +
            "                          ON r.id = rp.role_id\n" +
            "                LEFT JOIN pp_permission AS p\n" +
            "                          ON p.id = rp.permission_id\n" +
            "        WHERE u.phone = #{phone}")
    List<Permission> selectByUserPhone(@Param("phone") String phone);
}