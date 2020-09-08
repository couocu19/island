package com.service.impl;


import com.service.JwtAuthService;
import com.util.JwtTokenUtil;
import com.util.JwtTokenUtil1;
import org.springframework.jdbc.support.CustomSQLExceptionTranslatorRegistrar;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.annotation.Resource;

public class JwtAuthServiceImpl implements JwtAuthService {


    @Resource
    AuthenticationManager authenticationManager;


    @Resource
    SelfUserDetailsService userDetailsService;

    JwtTokenUtil1 jwtTokenUtil;

    /**
     * 登录认证换取jwt令牌
     * @param username
     * @param password
     * @return
     */
    public String login(String username,String password){

        try {
            UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username,password);
            Authentication authentication = authenticationManager.authenticate(upToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);


        } catch (AuthenticationException e) {
            System.out.println("用户名或者密码不正确");

        }


        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        return jwtTokenUtil.generateToken(userDetails);





    }





}
