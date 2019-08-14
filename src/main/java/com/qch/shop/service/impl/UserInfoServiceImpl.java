package com.qch.shop.service.impl;

import com.qch.shop.entity.UserInfo;
import com.qch.shop.repository.UserInfoRepository;
import com.qch.shop.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService{

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public void insert(UserInfo userInfo) {
        userInfoRepository.save(userInfo);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userInfoRepository.existsByUsername(username);
    }
}
