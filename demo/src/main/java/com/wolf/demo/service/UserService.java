package com.wolf.demo.service;

import com.wolf.demo.domain.User;

import java.util.List;

/**
 * @Author zhangle
 * @CreateTime 2021-12-16 13:58:09
 * @Description
 */
public interface UserService {
    boolean add(User user);

    List<User> queryUsers();

    boolean remove(Integer userId);
}
