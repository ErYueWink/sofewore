package com.xiaoxiao.dao;

import com.xiaoxiao.domain.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PermissionDao {

    void  add(@Param("permissionName") String permissionName,@Param("url") String url);

    void update(@Param("permissionName") String permissionName,@Param("url") String url,@Param("pid") Long pid);

    void delete(Long pid);

    Permission findById(Long pid);

    List<Permission> all();

    void deleteRoleToPermission(Long pid);





}
