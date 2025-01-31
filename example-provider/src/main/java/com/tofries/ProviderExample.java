package com.tofries;

import cn.hutool.core.net.NetUtil;
import com.tofries.config.RegistryConfig;
import com.tofries.config.RpcConfig;
import com.tofries.model.ServiceMetaInfo;
import com.tofries.registry.LocalRegistry;
import com.tofries.*;
import com.tofries.registry.Registry;
import com.tofries.registry.RegistryFactory;
import com.tofries.server.HttpServer;
import com.tofries.server.VertxHttpServer;
import com.tofries.server.VertxTcpServer;
import com.tofries.service.UserService;
import com.tofries.utils.*;


/**
 * 服务提供者示例

 */
public class ProviderExample {

    public static void main(String[] args) {
        // RPC 框架初始化
        RpcApplication.init();

        // 注册服务
        String serviceName = UserService.class.getName();
        LocalRegistry.register(serviceName, UserServiceImpl.class);

        // 注册服务到注册中心
        RpcConfig rpcConfig = RpcApplication.getRpcConfig();
        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
        Registry registry = RegistryFactory.getInstance();
        ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
        serviceMetaInfo.setServiceName(serviceName);
        serviceMetaInfo.setServiceHost(rpcConfig.getServerHost());
        serviceMetaInfo.setServicePort(rpcConfig.getServerPort());
        try {
            registry.register(serviceMetaInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 启动 TCP 服务
        VertxTcpServer vertxTcpServer = new VertxTcpServer();
        vertxTcpServer.doStart(8080);
    }
}
