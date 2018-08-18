package me.elvis.common.design.creation.factory;

public class WechatFactory implements IMsgFactory {
    @Override
    public CommonInterfaceSender createSender() {
        return new WechatSender();
    }
}
