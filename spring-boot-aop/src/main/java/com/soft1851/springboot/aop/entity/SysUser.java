package com.soft1851.springboot.aop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * 描述:
 *
 * @author：Guorc
 * @create 2020-04-13 17:52
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysUser {
    private String userId;
    private String userName;
    private Date createTime;
    private String password;
}
