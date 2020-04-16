package com.soft1851.springboot.aop.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author Guorc
 * @Date 2020/4/13
 */
@SpringBootTest
class RolePermissionMapperTest {
    @Resource
    private RolePermissionMapper mapper;

    @Test
    void getRoleById() {
        System.out.println(mapper.getRoleById(1));
    }
}