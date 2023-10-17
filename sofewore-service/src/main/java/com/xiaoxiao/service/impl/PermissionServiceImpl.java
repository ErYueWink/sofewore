package com.xiaoxiao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoxiao.dao.PermissionDao;
import com.xiaoxiao.domain.Permission;
import com.xiaoxiao.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public void add(Permission permission) {
        this.permissionDao.add(permission.getPermissionName(),permission.getUrl());
    }

    @Override
    public void update(Permission permission) {
        this.permissionDao.update(permission.getPermissionName(),permission.getUrl(),permission.getPid());
    }

    @Override
    public void delete(Long id) {
        // 删除角色_权限中间表数据
        this.permissionDao.deleteRoleToPermission(id);
        // 删除权限表数据
        this.permissionDao.delete(id);
    }

    @Override
    public Permission findById(Long id) {
        return this.permissionDao.findById(id);
    }

    @Override
    public PageInfo<Permission> search(int page, int size) {
        PageHelper.startPage(page,size);
        List<Permission> permissions = this.permissionDao.all();
        PageInfo<Permission> pageInfo = new PageInfo(permissions);
        return pageInfo;
    }

    @Override
    public List<Permission> all() {
        return this.permissionDao.all();
    }
}
