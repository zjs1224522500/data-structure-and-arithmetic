package me.elvis.common.design.creation.factory;

public class MailReceiver implements CommonInterfaceReceiver {
    @Override
    public void receiveMsg(String from) {
        System.out.println(String.format("Receive message from %s by email", from));
    }
}
