package com.xiaoxiao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoxiao.dao.RoleDao;
import com.xiaoxiao.domain.Role;
import com.xiaoxiao.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {


    @Autowired
    private RoleDao roleDao;

    @Override
    public void add(Role role) {
        this.roleDao.add(role.getRoleName(),role.getRoleDesc());
    }

    @Override
    public void update(Role role) {
        this.roleDao.update(role.getRoleName(),role.getRoleDesc(),role.getRid());
    }

    @Override
    public void delete(Long id) {
        this.roleDao.deletePermissionToRole(id);
        this.roleDao.delete(id);
    }

    @Override
    public PageInfo<Role> search(int page, int size) {
        PageHelper.startPage(page,size);
        List<Role> all = this.roleDao.all();
        PageInfo<Role> pageInfo = new PageInfo(all);
        return pageInfo;
    }

    @Override
    public Role findById(Long id) {
       return this.roleDao.findById(id);
    }

    @Override
    public void updatePermissionToRole(Long rid, Long[] pids) {
        this.roleDao.deletePermissionToRole(rid);
        for (Long pid : pids) {
            this.roleDao.insertPermissionToRole(rid,pid);
        }
    }

    @Override
    public List<Role> all() {
        return this.roleDao.all();
    }
}
