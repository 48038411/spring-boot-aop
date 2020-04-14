package com.soft1851.springboot.aop.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述:
 *
 * @author：Guorc
 * @create 2020-04-13 20:31
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RolePerVo {
    private String roleName;
    private String name;
}
