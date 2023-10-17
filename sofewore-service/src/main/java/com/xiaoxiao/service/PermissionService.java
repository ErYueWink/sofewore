package com.xiaoxiao.service;

import com.github.pagehelper.PageInfo;
import com.xiaoxiao.domain.Permission;

import java.util.List;

public interface PermissionService {

    void add(Permission permission);

    void update(Permission permission);

    void delete(Long id);

    Permission findById(Long id);

    PageInfo<Permission> search(int page,int size);

    List<Permission> all();

}
