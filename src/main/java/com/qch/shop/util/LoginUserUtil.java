package com.qch.shop.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import java.util.HashMap;
import java.util.Map;

public class LoginUserUtil {
    public static Map<String, String> getInfo() {
        Map<String, String> infoMap = new HashMap<>();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if("anonymousUser".equals(principal)) {
            return infoMap;
        }
        User user = (User) principal;
        infoMap.put("username", user.getUsername());
        return infoMap;
    }
}
