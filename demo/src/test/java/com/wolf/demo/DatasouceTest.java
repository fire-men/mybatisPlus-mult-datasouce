package com.wolf.demo;

import com.wolf.demo.domain.User;
import com.wolf.demo.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author zhangle
 * @CreateTime 2021-12-16 14:05:47
 * @Description
 */
@SpringBootTest
public class DatasouceTest {
    @Autowired
    private UserService userService;

    //使用默认数据源
    @Test
    public void addUser() {
        User user = new User();
        user.setName("上官婉儿");
        Assert.assertTrue("添加用户失败",userService.add(user));
    }

    //使用slave从数据读取数据
    @Test
    public void queryUserList(){
        userService.queryUsers().stream().forEach(user -> System.out.println(user));
    }

    //使用slave_2数据源删除用户，测试@DS注解--success
    @Test
    public void removeUser(){
        Assert.assertTrue("删除用户失败",userService.remove(2));
    }

}
