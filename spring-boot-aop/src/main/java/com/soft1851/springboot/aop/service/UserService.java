package com.soft1851.springboot.aop.service;

import com.soft1851.springboot.aop.entity.SysUser;
import com.soft1851.springboot.aop.entity.User;
import com.soft1851.springboot.aop.util.Result;

/**
 * 描述:
 *
 * @author：Guorc
 * @create 2020-04-13 20:58
 */
public interface UserService {
    /**
     * 登录
     * @return
     */
    Result login(User user);
}
