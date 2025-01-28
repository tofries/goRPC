package com.tofries;

import com.tofries.model.User;
import com.tofries.service.UserService;

/**
 * 用户服务实现类
 */
public class UserServiceImpl implements UserService {

    public User getUser(User user) {
        System.out.println("用户名：" + user.getName());
        return user;
    }
}
