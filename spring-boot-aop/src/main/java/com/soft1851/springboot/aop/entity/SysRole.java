package com.soft1851.springboot.aop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述:
 *
 * @author：Guorc
 * @create 2020-04-13 20:08
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SysRole {
    private Integer roleId;
    private String roleName;
    private String description;
}
