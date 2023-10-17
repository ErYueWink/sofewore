package com.xiaoxiao.domain;


import java.io.Serializable;
import java.util.List;

/**
 * 后台管理员用户
 */
public class Admin implements Serializable {
    private Long aid; // 用户id
    private String username; // 用户名
    private String password; // 密码
    private List<Role> roles; // 用户拥有的角色集合

    public Admin(Long aid, String username, String password) {
        this.aid = aid;
        this.username = username;
        this.password = password;
    }

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Admin() {
    }

    @Override
    public String toString() {
        return "Admin{" +
                "aid=" + aid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Admin(Long aid, String username, String password, List<Role> roles) {
        this.aid = aid;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }
}