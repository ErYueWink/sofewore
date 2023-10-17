package com.xiaoxiao.service;

import com.github.pagehelper.PageInfo;
import com.xiaoxiao.domain.Role;

import java.util.List;

public interface RoleService {

    void add(Role role);

    void update(Role role);

    void delete(Long id);

    PageInfo<Role> search(int page, int size);

    Role findById(Long id);

    void updatePermissionToRole(Long rid,Long[] pids);

    List<Role> all();
}
