package com.soft1851.springboot.aop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述:
 *
 * @author：Guorc
 * @create 2020-04-13 20:11
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
    private Integer id;
    private String userId;
    private Integer roleId;
}
