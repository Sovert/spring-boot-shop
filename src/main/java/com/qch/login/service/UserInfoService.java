package com.qch.login.service;

import com.qch.login.entity.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserInfoService {

    void insert(UserInfo userInfo);
}
