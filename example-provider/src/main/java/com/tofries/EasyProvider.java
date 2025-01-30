package com.tofries;

import com.tofries.registry.LocalRegistry;
import com.tofries.server.HttpServer;
import com.tofries.server.VertxHttpServer;
import com.tofries.service.UserService;

public class EasyProvider {
    public static void main(String[] args) {
        LocalRegistry.register(UserService.class.getName(),UserServiceImpl.class);

        HttpServer server = new VertxHttpServer();
        server.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}
