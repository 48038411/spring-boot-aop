package com.soft1851.springboot.aop.mapper;

import com.soft1851.springboot.aop.vo.UserRoleVo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserMapperTest {
    @Resource
    private UserMapper userMapper;
    @Test
    void selectByName() {
        System.out.println(userMapper.selectByName("guoruichang"));
    }

    @Test
    void selectPerNameByRoleId() {
        System.out.println(userMapper.selectPerNameByRoleId(1));
    }

    @Test
    void selectRoleByStuId() {
        System.out.println(userMapper.selectRoleByStuId("1802343306"));
    }

    @Test
    void getRoleIdByUserId() {
        UserRoleVo userRoleVo = userMapper.getRoleIdByUserId("1802343306");
        System.out.println(userRoleVo.getRoleId());
    }

    @Test
    void getRole() {
        System.out.println(userMapper.getRole(1));
    }
}