package com.xiaoxiao.controller;

import com.github.pagehelper.PageInfo;
import com.xiaoxiao.domain.Admin;
import com.xiaoxiao.result.AjaxResult;
import com.xiaoxiao.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@Api(value = "AdminController",description = "Admin",hidden = false)
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/search")
    @ApiOperation(value = "search")
    public AjaxResult<PageInfo<Admin>> search(@RequestParam(defaultValue = "1") int page,
                                              @RequestParam(defaultValue = "10") int size){
        PageInfo<Admin> pageInfo = this.adminService.search(page, size);
        return AjaxResult.ok(pageInfo);
    }

    @ApiOperation(value = "add")
    @PostMapping("/add")
    public AjaxResult add(@RequestBody Admin admin){
        this.adminService.add(admin);
        return AjaxResult.ok();
    }

    @ApiOperation(value = "update")
    @PutMapping("/update")
    public AjaxResult update(@RequestBody Admin admin){
        this.adminService.update(admin);
        return AjaxResult.ok();
    }

    @ApiOperation(value = "delete")
    @DeleteMapping("/delete")
    public AjaxResult delete(Long id){
        this.adminService.delete(id);
        return AjaxResult.ok();
    }

    @ApiOperation(value = "findById")
    @GetMapping("/findById")
    public AjaxResult<Admin> findById(Long id){
        Admin admin = this.adminService.findById(id);
        return AjaxResult.ok(admin);
    }

    @ApiOperation(value = "updateRoleToAdmin")
    @PutMapping("/updateRoleToAdmin")
    public AjaxResult updateRoleToAdmin(Long aid,Long[] rids){
        this.adminService.updateRoleToAdmin(aid,rids);
        return AjaxResult.ok();
    }






}
