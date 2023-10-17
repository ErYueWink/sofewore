package com.xiaoxiao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoxiao.dao.AdminDao;
import com.xiaoxiao.domain.Admin;
import com.xiaoxiao.domain.Permission;
import com.xiaoxiao.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;


    @Override
    public PageInfo<Admin> search(int page, int size) {
        PageHelper.startPage(page,size);
        List<Admin> adminList = adminDao.all();
        PageInfo<Admin> adminPageInfo = new PageInfo(adminList);
        return adminPageInfo;
    }

    @Override
    public void add(Admin admin) {
        this.adminDao.insert(admin.getUsername(),admin.getPassword());
    }

    @Override
    public void update(Admin admin) {
        this.adminDao.update(admin.getUsername(),admin.getPassword(),admin.getAid());
    }

    @Override
    public void delete(Long id) {
        this.adminDao.deleteAdminAllRole(id);
        this.adminDao.delete(id);
    }

    @Override
    public Admin findById(Long id) {
        return adminDao.findById(id);
    }

    @Override
    public void updateRoleToAdmin(Long aid, Long[] rids) {
        this.adminDao.deleteAdminAllRole(aid);
        for (Long rid : rids) {
            this.adminDao.insertRoleToAdmin(aid,rid);
        }
    }

    @Override
    public Admin findByUserName(String username) {
        return this.adminDao.findByUsername(username);
    }

    @Override
    public List<Permission> findAllPermission(Long id) {
        return this.adminDao.findAllPermission(id);
    }
}
