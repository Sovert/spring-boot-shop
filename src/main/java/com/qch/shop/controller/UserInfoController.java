package com.qch.shop.controller;

import com.qch.shop.entity.Result;
import com.qch.shop.entity.UserInfo;
import com.qch.shop.service.UserInfoService;
import com.qch.shop.util.LoginUserUtil;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.sql.SQLIntegrityConstraintViolationException;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result doRegister(@RequestBody @Valid UserInfo user) throws InterruptedException {
        if(userInfoService.existsByUsername(user.getUsername())) {
            return Result.error("用户已存在");
        }
        try {
            userInfoService.insert(user);
        } catch (DataIntegrityViolationException exception) {
            return Result.error("用户已存在");
        }

        return Result.ok();
    }

    @RequestMapping(value = "/info")
    public Result info(){
        return Result.ok("", LoginUserUtil.getInfo());
    }
}
