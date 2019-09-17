package com.qch.shop.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qch.shop.entity.Result;
import com.qch.shop.entity.UserInfo;
import com.qch.shop.filter.CustomAuthenticationFilter;
import com.qch.shop.service.UserInfoService;
import com.qch.shop.util.LoginUserUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserInfoService userInfoService;

    @Resource
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/**").permitAll()
                .and().formLogin()
                .and().logout().logoutUrl("/user/logout")
                .logoutSuccessHandler((request,response,authentication) -> {
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter out = response.getWriter();
                    out.write(new ObjectMapper().writeValueAsString(Result.ok()));
                    out.flush();
                    out.close();
                })
               .and().csrf().disable();
        httpSecurity.addFilterAt(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setHideUserNotFoundExceptions(false);
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new NoPasswordEncode());
        return provider;
    }
    @Bean
    CustomAuthenticationFilter customAuthenticationFilter() throws Exception {
        CustomAuthenticationFilter filter = new CustomAuthenticationFilter();
        filter.setAuthenticationSuccessHandler((req, resp, authentication) -> {
            resp.setContentType("application/json;charset=utf-8");
            PrintWriter out = resp.getWriter();

            Result result = Result.ok("登录成功!", LoginUserUtil.getInfo());
            out.write(new ObjectMapper().writeValueAsString(result));
            out.flush();
            out.close();
        });
        filter.setAuthenticationFailureHandler((req, resp, e) -> {
            resp.setContentType("application/json;charset=utf-8");
            PrintWriter out = resp.getWriter();
            Result respBean = Result.error(e instanceof UsernameNotFoundException ? "用户不存在" : "用户名或密码错误");
            out.write(new ObjectMapper().writeValueAsString(respBean));
            out.flush();
            out.close();
        });
        filter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/user/login", "POST"));
        filter.setAuthenticationManager(authenticationManagerBean());
        return filter;
    }
}
