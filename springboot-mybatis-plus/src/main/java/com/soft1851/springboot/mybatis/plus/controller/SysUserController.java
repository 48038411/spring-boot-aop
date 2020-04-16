package com.soft1851.springboot.mybatis.plus.controller;


import com.soft1851.springboot.mybatis.plus.mapper.SysUserMapper;
import com.soft1851.springboot.mybatis.plus.model.UserRolePer;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Guorc
 * @since 2020-04-16
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {
    @Resource
    private SysUserMapper mapper;
    @GetMapping("/juese")
    public List<UserRolePer> getPer(@Param("id") String id){
        return mapper.selectByUserId(id);
    }

}
