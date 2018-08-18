package me.elvis.common.design.creation.factory;

public class SmsReceiver implements CommonInterfaceReceiver {
    @Override
    public void receiveMsg(String from) {
        System.out.println(String.format("Receive message form %s by sms", from));
    }
}
