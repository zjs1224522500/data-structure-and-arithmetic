package me.elvis.common.design.creation.factory;

public class WechatSender implements CommonInterfaceSender {

    @Override
    public void sendMsg(String receiver) {
        System.out.println(String.format("Send to %s by WeChat", receiver));
    }
}
