package com.xiaoxiao.dao;

import com.xiaoxiao.domain.Admin;
import com.xiaoxiao.domain.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminDao {

    @Select("select * from bz_admin")
    List<Admin> all();

    void insert(@Param("username") String username,@Param("password") String password);

    void update(@Param("username") String username,@Param("password") String password,@Param("aid") Long aid);

    void delete(Long aid);

    Admin findById(Long aid);

    void insertRoleToAdmin(@Param("aid") Long aid,@Param("rid") Long rid);

    void deleteAdminAllRole(Long aid);

    Admin findByUsername(String username);

    List<Permission> findAllPermission(Long aid);
}
