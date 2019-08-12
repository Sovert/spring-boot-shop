package com.qch.login.controller;

import com.qch.login.entity.Result;
import com.qch.login.entity.UserInfo;
import com.qch.login.service.UserInfoService;
import com.qch.login.service.impl.UserInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result doRegister(@RequestBody UserInfo user) {
        userInfoService.insert(user);
        return Result.ok();
    }
}
