package com.xiaoxiao.controller;

import com.github.pagehelper.PageInfo;
import com.xiaoxiao.domain.Role;
import com.xiaoxiao.result.AjaxResult;
import com.xiaoxiao.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@Api(value = "RoleController")
public class RoleController {


    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "新增角色")
    @PostMapping("/add")
    public AjaxResult add(@RequestBody Role role){
        this.roleService.add(role);
        return AjaxResult.ok();
    }

    @ApiOperation(value = "修改角色")
    @PutMapping("/update")
    public AjaxResult update(@RequestBody Role role){
        this.roleService.update(role);
        return AjaxResult.ok();
    }

    @ApiOperation(value = "删除角色")
    @DeleteMapping("/delete")
    public AjaxResult delete(Long id){
        this.roleService.delete(id);
        return AjaxResult.ok();
    }

    @ApiOperation(value = "根据ID查询角色以及权限")
    @GetMapping("/findById")
    public AjaxResult<Role> findById(Long id){
        Role role = this.roleService.findById(id);
        return AjaxResult.ok(role);
    }

    @ApiOperation(value = "分页查询角色列表")
    @GetMapping("/search")
    public AjaxResult<PageInfo<Role>> search(@RequestParam(defaultValue = "1") int page,
                                             @RequestParam(defaultValue = "10") int size){
        PageInfo<Role> pageInfo = this.roleService.search(page, size);
        return AjaxResult.ok(pageInfo);
    }

    @ApiOperation(value = "修改角色权限")
    @PutMapping("/updatePermissionToRole")
    public AjaxResult updatePermissionToRole(Long rid,Long[] pids){
        this.roleService.updatePermissionToRole(rid,pids);
        return AjaxResult.ok();
    }

    @ApiOperation(value = "查询所有角色")
    @GetMapping("/findAll")
    public AjaxResult<List<Role>> findAll(){
        List<Role> list = this.roleService.all();
        return AjaxResult.ok(list);
    }
}
