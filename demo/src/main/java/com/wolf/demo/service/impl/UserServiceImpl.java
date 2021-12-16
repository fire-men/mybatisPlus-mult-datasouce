package com.wolf.demo.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.wolf.demo.domain.User;
import com.wolf.demo.mapper.UserMapper;
import com.wolf.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zhangle
 * @CreateTime 2021-12-16 13:59:04
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean add(User user) {
        return userMapper.insert(user) > 0 ? true : false;
    }

    @DS(value = "slave")
    @Override
    public List<User> queryUsers() {
        return userMapper.selectAllUsers();
    }

    @DS(value = "slave_2")
    @Override
    public boolean remove(Integer userId) {
        return userMapper.deleteByPrimaryKey(userId) > 0 ? true : false;
    }
}
