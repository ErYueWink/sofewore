package com.xiaoxiao.security;

import com.xiaoxiao.dao.AdminDao;
import com.xiaoxiao.domain.Admin;
import com.xiaoxiao.domain.Permission;
import com.xiaoxiao.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private AdminService adminService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Admin admin = this.adminService.findByUserName(username);
        if(admin == null){
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        List<GrantedAuthority> grantedAuthorityList = new ArrayList();
        List<Permission> permissionList = this.adminService.findAllPermission(admin.getAid());
        permissionList.forEach(permission -> {
            grantedAuthorityList.add(new SimpleGrantedAuthority(permission.getUrl()));
        });
        UserDetails details = User.withUsername(admin.getUsername())
                .password(admin.getPassword())
                .authorities(grantedAuthorityList)
                .build();

        return details;
    }
}
