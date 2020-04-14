package com.soft1851.springboot.aop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述:
 *
 * @author：Guorc
 * @create 2020-04-13 20:14
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RolePermission {
    private Integer id;
    private Integer roleId;
    private Integer pId;
}
