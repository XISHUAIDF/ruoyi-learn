package com.ruoyi.competition.model;

import com.ruoyi.common.core.domain.model.LoginUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
/*登录用*/
public class ParticipantsLoginUser extends LoginUser implements UserDetails {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户唯一标识
     */
    private String token;

    private String username;


    private String password;

    /**
     * 用户权限列表
     */
    private Collection<? extends GrantedAuthority> authorities;

    public ParticipantsLoginUser(Long userId, String token, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.userId = userId;
        this.token = token;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public ParticipantsLoginUser(Long id, String password) {
        this.userId = id;
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
