package com.soft1851.springboot.mybatis.plus.mapper;

import com.soft1851.springboot.mybatis.plus.model.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SysUserMapperTest {
    @Resource
    private SysUserMapper mapper;
    @Test
    void selectByUserId() {
        String id = "1802343306";
        System.out.println(mapper.selectByUserId(id));
    }
    @Test
    void select(){
        List<SysUser> all = mapper.selectList(null);
        all.forEach(System.out::println);
    }
}