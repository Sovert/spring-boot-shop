package com.qch.shop.controller;

import com.qch.shop.entity.Result;
import com.qch.shop.entity.UserInfo;
import com.qch.shop.service.UserInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

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
    public Result doRegister(@RequestBody @Valid UserInfo user) throws InterruptedException {
        if(userInfoService.existsByUsername(user.getUsername())) {
            return Result.error("用户已存在");
        }
        Thread.sleep(2000);
        userInfoService.insert(user);
        return Result.ok();
    }
}
