package com.soft1851.springboot.aop.mapper;

import com.soft1851.springboot.aop.entity.SysRole;
import com.soft1851.springboot.aop.entity.SysUser;
import com.soft1851.springboot.aop.vo.RolePerVo;
import com.soft1851.springboot.aop.vo.UserRoleVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 描述:
 *
 * @author：Guorc
 * @create 2020-04-13 20:15
 */
public interface UserMapper {
    /**
     * 根据id查询用户信息
     * @param userId
     * @return
     */
    @Select("SELECT t1.*, t2.* " +
            "FROM user_role t3 " +
            "LEFT JOIN sys_user t1 " +
            "ON t1.user_id = t3.user_id " +
            "LEFT JOIN sys_role t2 " +
            "ON t2.role_id = t3.role_id " +
            "WHERE t3.user_id=#{userId}")
    Map<String,Object> getUserById(String userId);
    /**
     * 根据用户名查找用户
     * @param name
     * @return
     */
    @Select("SELECT * FROM sys_user WHERE user_name= #{name} ")
    SysUser selectByName(@Param("name") String name);

    /**
     * 根据角色id查找该角色下有几个资源
     * @param id
     * @return
     */
    @Select("SELECT t3.role_name,t2.name FROM  role_permission  LEFT JOIN  sys_permission t2 on role_permission.p_id=t2.id LEFT JOIN sys_role t3 ON t3.role_id = role_permission.role_id WHERE t3.role_id = #{id}")
    List<RolePerVo> selectPerNameByRoleId(@Param("id") int id);

    /**
     * 根据用户id查询其角色身份
     * @param userId
     * @return
     */
    @Select("SELECT t1.user_id,t1.user_name,t1.create_time,t2.role_name,t2.role_id,t2.description FROM `user_role` LEFT JOIN sys_user t1 on t1.user_id = user_role.user_id LEFT JOIN sys_role t2 on t2.role_id = user_role.role_id where t1.user_id = #{userId}")
    List<UserRoleVo> selectRoleByStuId(@Param("userId") String userId);

    /**
     * 根据用户id查找角色id
     * @param userId
     * @return
     */
    @Select("SELECT t2.role_id FROM `user_role` LEFT JOIN sys_user t1 on t1.user_id = user_role.user_id LEFT JOIN sys_role t2 on t2.role_id = user_role.role_id where t1.user_id = #{userId}")
    UserRoleVo getRoleIdByUserId(@Param("userId") String userId);

    /**
     * 判断有没有这个roleId
     * @param roleId
     * @return
     */
    @Select("SELECT * FROM sys_role WHERE role_id = #{roleId}")
    SysRole getRole(int roleId);
}