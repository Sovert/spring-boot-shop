package com.qch.shop.service;

import com.qch.shop.entity.UserInfo;

public interface UserInfoService {

    void insert(UserInfo userInfo);

    boolean existsByUsername(String username);
}
