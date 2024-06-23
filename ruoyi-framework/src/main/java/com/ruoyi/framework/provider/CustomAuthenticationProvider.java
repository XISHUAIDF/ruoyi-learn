package com.ruoyi.framework.provider;

import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.net.URI;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    @Qualifier("userDetailsServiceImpl")
    private UserDetailsService userDetailsServiceImpl;


    @Autowired
    @Qualifier("customUserDetailsService")
    private UserDetailsService customUserDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        UserDetails userDetails;
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String requestURI = attributes.getRequest().getRequestURI();
        URI uri = URI.create(requestURI);
        String path = uri.getPath();
        // 根据条件选择不同的 UserDetailsService 进行认证
        if (path.equals("/partipantsLogin/login")) {
            userDetails = customUserDetailsService.loadUserByUsername(username);
        } else {
            userDetails = userDetailsServiceImpl.loadUserByUsername(username);
        }


        // 自定义认证逻辑，例如密码验证
        // 这里假设使用密码匹配的方式进行认证
        if (!SecurityUtils.matchesPassword(password,userDetails.getPassword())) {
            throw new BadCredentialsException("密码错误");
        }

        // 返回认证后的 Authentication 对象
        return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
