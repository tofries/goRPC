package com.tofries;

import com.tofries.config.RpcConfig;
import com.tofries.model.User;
import com.tofries.proxy.ServiceProxyFactory;
import com.tofries.service.UserService;
import com.tofries.utils.ConfigUtils;

public class EasyConsumer {
    public static void main(String[] args) {
        RpcConfig rpcConfig = ConfigUtils.loadConfig(RpcConfig.class,"rpc");
        System.out.println(rpcConfig);

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
