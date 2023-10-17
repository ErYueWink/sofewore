package com.xiaoxiao;

import com.github.pagehelper.PageInfo;
import com.xiaoxiao.domain.Admin;
import com.xiaoxiao.service.impl.AdminServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SofeWoreServiceApplication.class)
public class TestAdmin {
    @Autowired
    private AdminServiceImpl adminService;

    @Test
    public void test1(){
        PageInfo<Admin> adminPageInfo = this.adminService.search(1,5);
        System.out.println(adminPageInfo);
    }

    @Test
    public void test2(){
        Admin admin = new Admin(81l,"zhangsan2","zhangsan2");
        this.adminService.update(admin);
    }
}
