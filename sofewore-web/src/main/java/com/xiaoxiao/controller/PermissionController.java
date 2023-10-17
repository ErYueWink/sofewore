package com.xiaoxiao.controller;

import com.github.pagehelper.PageInfo;
import com.xiaoxiao.domain.Permission;
import com.xiaoxiao.result.AjaxResult;
import com.xiaoxiao.service.PermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permission")
@Api(value = "PermissionController",description = "后台权限控制器",hidden = false)
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @ApiOperation(value = "新增权限")
    @PostMapping("/add")
    public AjaxResult add(@RequestBody Permission permission){
        this.permissionService.add(permission);
        return AjaxResult.ok();
    }

    @ApiOperation(value = "修改权限")
    @PutMapping("/update")
    public AjaxResult update(@RequestBody Permission permission){
        this.permissionService.update(permission);
        return AjaxResult.ok();
    }

    @ApiOperation(value = "删除权限")
    @DeleteMapping("/delete")
    public AjaxResult delete(Long pid){
        this.permissionService.delete(pid);
        return AjaxResult.ok();
    }

    @ApiOperation(value = "根据ID查询权限")
    @GetMapping("/findById")
    public AjaxResult<Permission> findById(Long pid){
        Permission permission = this.permissionService.findById(pid);
        return AjaxResult.ok(permission);
    }

    @ApiOperation(value = "分页查询权限列表")
    @GetMapping("/search")
    public AjaxResult<PageInfo<Permission>> search(@RequestParam(defaultValue = "1") int page,
                                                   @RequestParam(defaultValue = "10") int size){
        PageInfo<Permission> pageInfo = this.permissionService.search(page, size);
        return AjaxResult.ok(pageInfo);
    }

    @ApiOperation(value = "查询所有权限")
    @GetMapping("/findAll")
    public AjaxResult<List<Permission>> findAll(){
        List<Permission> permissions = this.permissionService.all();
        return AjaxResult.ok(permissions);
    }



}
