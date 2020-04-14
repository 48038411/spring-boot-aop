package com.soft1851.springboot.aop.aspect;

import com.soft1851.springboot.aop.annotation.AuthToken;
import com.soft1851.springboot.aop.entity.SysUser;
import com.soft1851.springboot.aop.mapper.UserMapper;
import com.soft1851.springboot.aop.service.UserService;
import com.soft1851.springboot.aop.util.Result;
import com.soft1851.springboot.aop.util.ResultCode;
import com.soft1851.springboot.aop.vo.RolePerVo;
import com.soft1851.springboot.aop.vo.UserRoleVo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:认证授权的切面逻辑
 *
 * @author：Guorc
 * @create 2020-04-13 15:40
 */
@Aspect
@Component
@Slf4j
public class AuthTokenAspect {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserService userService;
    /**
     * ThreadLocal可以让我们拥有当前线程的变量，可以通过set()和get()来对每个局部变量进行操作
     * 不会和其他线程的局部变量进行冲突，实现了线程的数据隔离
     * 此处用它进行日志信息在各个方法间的共享
     */
    private ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<>();
    /**
     * 配置加上自定义注解的方法为切点
     * @param authToken
     */
    @Pointcut("@annotation(authToken)")
    public void doAuthToken(AuthToken authToken){
    }
    /**
     * 前置增强
     *
     * @param joinpoint
     * @param authToken
     */
    @Before(value = "@annotation(authToken)")
    public void doBefore(JoinPoint joinpoint, AuthToken authToken) {
        //接受请求，取得请求的request对象
        RequestAttributes at = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) at;
        //以下通过连接点和注解获取到相关信息
        assert sra != null;
        HttpServletRequest request = sra.getRequest();
        log.info("请求URI：" + request.getRequestURI());
        log.info("请求URL：" + request.getRequestURL());
        log.info("请求头的User-Agent：" + request.getHeader("User-Agent"));
        log.info("请求方法：" + request.getMethod());
        log.info("请求地址：" + request.getRemoteAddr());
        log.info("连接点对象通过反射获得类名和方法名" + joinpoint.getSignature().getDeclaringTypeName() + "."
                + joinpoint.getSignature().getName());
        log.info("AOP拦截获得参数：" + Arrays.toString(joinpoint.getArgs()));
        //定义一个map用来记录日志信息，并将其put入threadLocal
        Map<String, Object> map = new HashMap<>(16);
        map.put("uri", request.getRequestURI());
        map.put("url", request.getRequestURL());
        map.put("user-agent", request.getHeader("User-Agent"));
        map.put("request-method", request.getMethod());
        map.put("remote-address", request.getRemoteAddr());
        map.put("class-method", joinpoint.getSignature().getDeclaringTypeName() + "."
                + joinpoint.getSignature().getName());
        map.put("arguments", Arrays.toString(joinpoint.getArgs()));
        threadLocal.set(map);


//        log.info("请求方法名：" + controllerWebLog.name());
//        log.info("是否需要持久化该条日志：" + controllerWebLog.isSaved());
//        log.info("AOP拦截获得参数：" + Arrays.toString(joinpoint.getArgs()));
    }
    /**
     * 执行成功处理
     *
     * @param authToken
     * @param ret
     * @throws Throwable
     */
    @AfterReturning(value = "doAuthToken(authToken)", returning = "ret")
    public void doAfterReturning(AuthToken authToken, Object ret) throws Throwable {
        //从当前线程变量取出数据
        Map<String, Object> threadInfo = threadLocal.get();
        //将请求的目标方法getHello()的执行的返回结果存入线程对象
//        threadInfo.put("result", ret);
        //处理完请求，返回内容
        log.info("RESPONSE：" + ret);
    }
    @Around(value = "doAuthToken(authToken)",argNames = "pjp,authToken")
    public Object doAround(ProceedingJoinPoint pjp,AuthToken authToken) throws Throwable {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert sra != null;
        HttpServletRequest request = sra.getRequest();
//        String userName = request.getParameter("userName");
//        String password = request.getParameter("password");
//        if (userName == null && password == null) {
//            return Result.failure(ResultCode.USER_NOT_SIGN_IN);
//        }

        //取得注解中的role_name的值
//        String[] roleNames = authToken.role_name();
        //没有role的值
//        if (roleNames.length <= 1){
//            if (id1 != null){
//                if (userMapper.getRole(id1) != null){
//                    return pjp.proceed();
//                }
//                return Result.failure(ResultCode.PERMISSION_NO_ACCESS);
//            }
        //只需要认证（登录）
        String id = request.getHeader("id");
        //如果id是空的，可以调用目标方法
        if (id != null) {
            UserRoleVo userRoleVo = userMapper.getRoleIdByUserId(id);
            List<RolePerVo> role = userMapper.selectPerNameByRoleId(userRoleVo.getRoleId());
            return Result.success(role);
        }
        return Result.failure(ResultCode.PERMISSION_NO_ACCESS);
//        else {
//            //验证身份
//            String role = request.getHeader("role_name");
////            log.info(role);
//            //遍历roleNames数组，匹配role
//            for (String roleName: roleNames
//                 ) {
//                if (roleName.equals(role)){
//                    //身份匹配成功
//                    return pjp.proceed();
//                }
//            }
//        return Result.failure(ResultCode.PERMISSION_NO_ACCESS);

//        }


    }
}
