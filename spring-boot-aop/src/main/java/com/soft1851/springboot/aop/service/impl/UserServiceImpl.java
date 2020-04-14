package com.soft1851.springboot.aop.service.impl;

import com.soft1851.springboot.aop.entity.SysUser;
import com.soft1851.springboot.aop.entity.User;
import com.soft1851.springboot.aop.mapper.UserMapper;
import com.soft1851.springboot.aop.service.UserService;
import com.soft1851.springboot.aop.util.Result;
import com.soft1851.springboot.aop.util.ResultCode;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.digest.DigestUtils;
import javax.annotation.Resource;

/**
 * 描述:
 *
 * @author：Guorc
 * @create 2020-04-13 20:59
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public Result login(User user) {
        SysUser sysUser = null;
        sysUser = userMapper.selectByName(user.getUserName());
        if (sysUser != null) {
            System.out.println(DigestUtils.md5Hex(user.getPassword()));
            if (DigestUtils.md5Hex(user.getPassword()).equals(sysUser.getPassword())) {
                return Result.success(sysUser);
            } else {
                return Result.failure(ResultCode.USER_PASSWORD_ERROR);
            }
        } else {
            return Result.failure(ResultCode.USER_NOT_EXIST);
        }
    }
}
