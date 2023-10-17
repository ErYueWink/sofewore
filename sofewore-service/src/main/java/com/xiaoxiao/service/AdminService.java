package com.xiaoxiao.service;

import com.github.pagehelper.PageInfo;
import com.xiaoxiao.domain.Admin;
import com.xiaoxiao.domain.Permission;

import java.util.List;

public interface AdminService {

    PageInfo<Admin> search(int page,int size);

    void add(Admin admin);

    void update(Admin admin);

    void delete(Long id);

    Admin findById(Long id);

    void updateRoleToAdmin(Long aid,Long[] rids);

    Admin findByUserName(String username);

    List<Permission> findAllPermission(Long id);



}
