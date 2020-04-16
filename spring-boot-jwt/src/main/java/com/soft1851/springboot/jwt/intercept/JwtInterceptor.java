package com.soft1851.springboot.jwt.intercept;

import com.soft1851.springboot.jwt.common.ResultCode;
import com.soft1851.springboot.jwt.exception.JwtException;
import com.soft1851.springboot.jwt.service.AdminService;
import com.soft1851.springboot.jwt.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName JwtInterceptor
 * @Description Jwt拦截器
 * @Author Guorc
 * @Date 2020/4/15
 * @Version 1.0
 */
@Slf4j
@Component
public class JwtInterceptor implements HandlerInterceptor {
    @Resource
    private AdminService adminService;

    /**
     * 前置处理，拦截请求
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if (token == null) {
            log.info("### 用户未登录，请先登录 ###");
            throw new JwtException("用户未登录，请先登录", ResultCode.USER_NOT_SIGN_IN);
        } else {
            //已经登录
            log.info("###token={}",token);
            //鉴权
            if (!adminService.checkRole(JwtTokenUtil.getUserRole(token))) {
//                System.out.println(JwtTokenUtil.getUserRole(token));
                log.info("###用户权限不足###");
                //通过自定义异常抛出权限不足的信息，由全局统一处理
                throw new JwtException("用户权限不足", ResultCode.USER_NO_AUTH);
            } else {
                return true;
////                log.info(String.valueOf(JwtTokenUtil.isExpiration(token)));
//                long time = JwtTokenUtil.deToken(token).getExpiresAt().getTime();
//                System.out.println(System.currentTimeMillis() - time > 0);
//                if (JwtTokenUtil.isExpiration(token)) {
//                    log.info("token已失效");
////                    throw new JwtException("token已失效", ResultCode.TOKEN_HAS_EXPIRE);
//                    return false;
//                } else {
//                    return true;
//                }

            }

        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
