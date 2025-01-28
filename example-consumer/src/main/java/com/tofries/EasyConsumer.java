package com.tofries;

import com.tofries.model.User;
import com.tofries.service.UserService;

public class EasyConsumer {
    public static void main(String[] args) {
        // todo 需要获取 UserService 的实现类对象
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("yupi");
        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }
    }
}
