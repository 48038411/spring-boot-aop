package com.soft1851.springboot.aop.controller;

import com.soft1851.springboot.aop.annotation.AuthToken;
import com.soft1851.springboot.aop.entity.User;
import com.soft1851.springboot.aop.mapper.UserMapper;
import com.soft1851.springboot.aop.service.UserService;
import com.soft1851.springboot.aop.util.Result;
import com.soft1851.springboot.aop.util.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 描述:
 *
 * @author：Guorc
 * @create 2020-04-13 15:21
 */
@RestController
@Slf4j
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private UserMapper userMapper;
    /**
     * 无需任何校验，不用加注解
     * @param user
     * @return
     */
    @GetMapping("login")
    public Result hello(User user){
        return userService.login(user);
    }

    /**
     * 需要认证，此时该方法需要加注解，但是不需要传角色
     * @param name
     * @return
     */
    @GetMapping("user")
    @AuthToken
    public Result user(String name){
        return Result.success("登陆成功");
    }

    /**
     * 需要鉴权，此时该方法需要加注解，需要传角色
     * 角色可以传多个
     * 如果需要更复杂的逻辑操作，建议使用框架（Spring Security，Apache Shiro）等安全框架
     * @return
     */
    @GetMapping("admin")
    @AuthToken()
    public Result admin(){
        return Result.success();
    }
//    @GetMapping("permission")
//    @AuthToken
//    public Result per(int id){
//        return Result.success(userMapper.selectPerNameByRoleId(id));
//    }
}
