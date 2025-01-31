package com.tofries.protocol;

/**
 * 协议常量
 *
 */
public class ProtocolConstant {

    /**
     * 消息头长度
     */
    public int MESSAGE_HEADER_LENGTH = 17;

    /**
     * 协议魔数
     * todo 更新魔数的检验机制
     */
    public static byte PROTOCOL_MAGIC = 0x1;

    /**
     * 协议版本号
     */
    public static byte PROTOCOL_VERSION = 0x1;

    /**
     * 序列化器
     */
    public static byte SERIALIZER = 0x0;
}
