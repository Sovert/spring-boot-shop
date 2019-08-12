package com.qch.login.service.impl;

import com.qch.login.entity.UserInfo;
import com.qch.login.repository.UserInfoRepository;
import com.qch.login.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService{

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public void insert(UserInfo userInfo) {
        userInfoRepository.save(userInfo);
    }
}
