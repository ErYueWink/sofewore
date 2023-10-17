package com.xiaoxiao.domain;


import java.io.Serializable;

/**
 * 后台管理员权限
 */
public class Permission implements Serializable {
    private Long pid; // 权限id
    private String permissionName; // 权限名
    private String url; // 权限的资源路径


    @Override
    public String toString() {
        return "Permission{" +
                "pid=" + pid +
                ", permissionName='" + permissionName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public Permission() {
    }

    public Permission(Long pid, String permissionName, String url) {
        this.pid = pid;
        this.permissionName = permissionName;
        this.url = url;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }
}