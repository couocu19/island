package com.service.impl;

import com.config.SelfUserDetails;
import com.dao.MenuMapper;
import com.dao.RoleMapper;
import com.dao.UserMapper;
import com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//为spring-security提供用户角色权限信息
//注意：角色也是一个特殊的权限，应该加入到set中，前缀是"ROLE_"
@Component
public class SelfUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private MenuMapper menuMapper;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SelfUserDetails selfUserDetails = new SelfUserDetails();

        //加载基础用户信息
        User user = userMapper.selectByUsername(username);
        selfUserDetails.setUsername(user.getUsername());
        selfUserDetails.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        //加载用户角色以及权限列表
        String role = roleMapper.selectByUsername(username);
        List<String> menus = menuMapper.selectByRoleName(role);


        //这里比较迷惑
        Set set = new HashSet<>();
        set.add(new SimpleGrantedAuthority(role));
        GrantedAuthority authority = null;
        for(String s:menus){
            authority = new SimpleGrantedAuthority(s);
            set.add(authority);
        }

        selfUserDetails.setAuthorities(set);



        return selfUserDetails;
    }
}

