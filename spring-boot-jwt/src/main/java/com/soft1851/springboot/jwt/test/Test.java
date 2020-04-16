package com.soft1851.springboot.jwt.test;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.soft1851.springboot.jwt.util.Decrypt;
import com.soft1851.springboot.jwt.util.Encrypt;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Date;

/**
 * @ClassName Test
 * @Description TODO
 * @Author mq_xu
 * @Date 2020/4/15
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        // 生成token
        Encrypt encrypt = new Encrypt();
        String token = encrypt.getToken(true, "soft1851", "软件1851","1802343306");

        // 打印token
        System.out.println("token: " + token);

        // 解密token
        Decrypt decrypt = new Decrypt();
        DecodedJWT jwt = decrypt.deToken(token);

        System.out.println("issuer: " + jwt.getIssuer());
        System.out.println("isVip:  " + jwt.getClaim("isVip").asBoolean());
        System.out.println("username: " + jwt.getClaim("username").asString());
        System.out.println("name:     " + jwt.getClaim("name").asString());
        System.out.println("userId:" +jwt.getClaim("userId").asString());
        System.out.println("过期时间：      " + jwt.getExpiresAt());
        System.out.println(DigestUtils.md5Hex("1802343306"));

    }
}
