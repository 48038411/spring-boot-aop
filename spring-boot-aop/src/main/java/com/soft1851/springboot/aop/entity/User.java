package com.soft1851.springboot.aop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述:
 *
 * @author：Guorc
 * @create 2020-04-13 21:06
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String userName;
    private String password;
}
