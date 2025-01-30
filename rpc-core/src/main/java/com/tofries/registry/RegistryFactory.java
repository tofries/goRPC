package com.tofries.registry;

import com.tofries.registry.EtcdRegistry;
import com.tofries.registry.Registry;
/**
 * 注册中心工厂（用于获取注册中心对象）
 *
 */
public class RegistryFactory {


    /**
     * 默认注册中心
     */
    private static final Registry DEFAULT_REGISTRY = new EtcdRegistry();

    /**
     * 获取实例
     *
     * @return
     */
    public static Registry getInstance() {
        return DEFAULT_REGISTRY;
    }

}
