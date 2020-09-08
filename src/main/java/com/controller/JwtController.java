package com.controller;

import com.qiniu.util.StringUtils;
import com.service.JwtAuthService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class JwtController {

    @Resource
    JwtAuthService jwtAuthService;


    public Map<String,Object> loginJwt(@RequestBody Map<String,String> map){
        String username = map.get("username");
        String password = map.get("password");
        Map<String,Object> res = new HashMap<>();

        if(StringUtils.isNullOrEmpty(username) || StringUtils.isNullOrEmpty(password)){
            res.put("msg","用户名或者密码不能为空");
        }

        try {
            String s = jwtAuthService.login(username,password);
            res.put("token",s);
        } catch (Exception e) {
            res.put("msg","error");

        }

        return res;


    }









}
