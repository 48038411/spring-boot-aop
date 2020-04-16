package com.soft1851.springboot.jwt.test;

import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.soft1851.springboot.jwt.util.Decrypt;

import java.util.Date;

/**
 * 描述:
 *
 * @author：Guorc
 * @create 2020-04-15 11:00
 */
public class TokenTest {
    public static void main(String[] args) {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJhdXRoMCIsIm5hbWUiOiLova_ku7YxODUxIiwiZXhwIjoxNTg2OTIyMzc2LCJ1c2VySWQiOiIxODAyMzQzMzA2IiwiaXNWaXAiOnRydWUsInVzZXJuYW1lIjoic29mdDE4NTEifQ.1VJu3FulnDQ91yp3imifPBZD_gg3P2qhKOEs3kD58wk";
        // 解密token
        Decrypt decrypt = new Decrypt();
        DecodedJWT jwt = decrypt.deToken(token);
        String userId = "18023433026";
//        System.out.println(jwt.getExpiresAt());
//        System.out.println(new Date());
//        System.out.println(jwt.getExpiresAt().after(new Date()));
        try{
            if (jwt.getExpiresAt().after(new Date())){
                if (jwt.getClaim("userId").asString().equals(userId)){
                    System.out.println("issuer: " + jwt.getIssuer());
                    System.out.println("isVip:  " + jwt.getClaim("isVip").asBoolean());
                    System.out.println("username: " + jwt.getClaim("username").asString());
                    System.out.println("name:     " + jwt.getClaim("name").asString());
                }else {
                    System.out.println("用户id不对");
                }
            }else {
                System.out.println("token已过期！");
            }
        }catch (TokenExpiredException e){
            System.out.println("token已过期");
        }
    }
}
