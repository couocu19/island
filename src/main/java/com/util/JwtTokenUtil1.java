package com.util;

import io.jsonwebtoken.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties(prefix = "jwt" )
@Component
public class JwtTokenUtil1 {


    private String secret;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Long getExpiration() {
        return expiration;
    }

    public void setExpiration(Long expiration) {
        this.expiration = expiration;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    private Long expiration;
    private String header;


    /**
     * 生成token令牌
     * @param userDetails 用户
     * @return token令牌
     */
    public String generateToken(UserDetails userDetails){
        Map<String,Object> claims = new HashMap<>(2);
        claims.put("sub",userDetails.getUsername());
        claims.put("created",new Date());
        return generateToken(claims);
    }

    /**
     * 从claims生成令牌，如果卡不懂就看谁调用它
     * 生成过程中使用加密算法进行加密
     *
     * @param claims 数据声明
     * @return 令牌
     */
    private String generateToken(Map<String,Object> claims){
        Date expirationDate = new Date(System.currentTimeMillis()+expiration);

        return Jwts.builder().setClaims(claims)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512,secret) //指定签名算法是HS521 //secret:用来对前两部分数据进行签名和解签
                .compact();
    }


    /**
     * 从令牌中获取用户名
     * @param token
     * @return
     */
    public String getUsernameFromToken(String token){
        String username;

        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject(); //subject也就是需要得到信息的用户名
        } catch (Exception e) {
            username = null;
        }

        return username;

    }


    /**
     *
     * 从令牌中获取数据声明，看不懂就看谁调用它
     *
     * @param token 令牌
     * @return 数据声明
     */
    private Claims getClaimsFromToken(String token){
        Claims claims;

        try {
            claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            claims = null;
        }

        return claims;
    }

    /**
     * 判断令牌是否过期
     * 在鉴权期间的校验token是否合法期间调用该方法
     *
     * @param token 令牌
     * @return 是否过期
     */
    public Boolean isTokenExpired(String token){

        try {
            Claims claims = getClaimsFromToken(token);
            Date expiration = claims.getExpiration();
            return expiration.before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 刷新令牌
     *
     * @param token 原令牌,即拿原令牌换取旧令牌，说白了就是更新原令牌的过期时间
     * @return 新令牌
     */
    public String refreshToken(String token){
        String refreshedToken;

        try {
            Claims claims = getClaimsFromToken(token);
            claims.put("created",new Date());
            refreshedToken = generateToken(claims);
        } catch (Exception e) {
            refreshedToken = null;
        }

        return refreshedToken;
    }

    /**
     * 验证令牌
     * @param token 令牌
     * @param userDetails  用户
     * @return 是否有效
     */
    public Boolean validateToken(String token,UserDetails userDetails){
        String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));

    }








}
