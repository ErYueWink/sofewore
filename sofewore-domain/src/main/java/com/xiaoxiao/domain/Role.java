package com.xiaoxiao.domain;


import java.io.Serializable;
import java.util.List;

/*
 * 后台管理员角色
 */
public class Role implements Serializable {
    private Long rid; // 角色id
    private String roleName; // 角色名
    private String roleDesc; // 角色介绍
    private List<Permission> permissions; // 角色拥有的权限集合

    @Override
    public String toString() {
        return "Role{" +
                "rid=" + rid +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", permissions=" + permissions +
                '}';
    }

    public Role() {
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public Role(Long rid, String roleName, String roleDesc, List<Permission> permissions) {
        this.rid = rid;
        this.roleName = roleName;
        this.roleDesc = roleDesc;
        this.permissions = permissions;
    }
}