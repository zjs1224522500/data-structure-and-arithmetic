package me.elvis.common.design.observer;

public class Test {

    public static void main(String[] args) {
        WechatServer wechatServer = new WechatServer();
        Observer elvis = new User("elvis");
        Observer vanm = new User("vanm");
        Observer vanes = new User("vanes");

        wechatServer.registerObserver(elvis);
        wechatServer.registerObserver(vanes);
        wechatServer.registerObserver(vanm);

        wechatServer.setInformation("To be or not to be, this is a question");

        wechatServer.removeObserver(vanm);
        wechatServer.setInformation("To be.");
    }
}
