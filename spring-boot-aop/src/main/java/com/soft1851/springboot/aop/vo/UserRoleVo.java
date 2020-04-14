package com.soft1851.springboot.aop.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * 描述:
 *
 * @author：Guorc
 * @create 2020-04-13 20:37
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleVo {
    private Integer roleId;
    private String userId;
    private String userName;
    private Date createTime;
    private String roleName;
    private String description;
}
