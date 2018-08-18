package me.elvis.common.design.creation.factory;

public class FactoryMethodMain {
    public static void main(String[] args) {
        IMsgFactory factory = new SendMailFactory();
        //IMsgFactory factory = new SendSmsFactory();
        //IMsgFactory factory = new WechatFactory();
        CommonInterfaceSender sender = factory.createSender();
        sender.sendMsg("Elvis");
    }
}
