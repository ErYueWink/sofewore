package com.xiaoxiao.dao;

import com.xiaoxiao.domain.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleDao {

    List<Role> all();

    void add(@Param("roleName") String roleName,@Param("roleDesc") String roleDesc);

    void update(@Param("roleName") String roleName,@Param("roleDesc") String roleDesc,@Param("rid") Long rid);

    void delete(Long rid);

    Role findById(Long rid);

    void insertPermissionToRole(@Param("rid") Long rid,@Param("pid") Long pid);

    void deletePermissionToRole(Long rid);

}
