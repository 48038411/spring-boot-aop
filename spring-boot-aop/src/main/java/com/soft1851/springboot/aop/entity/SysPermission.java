package com.soft1851.springboot.aop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述:
 *
 * @author：Guorc
 * @create 2020-04-13 20:12
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SysPermission {
    private Integer id;
    private Integer parentId;
    private Integer type;
    private String name;
    private String icon;
    private String path;
    private String ex1;
    private String ex2;
}
