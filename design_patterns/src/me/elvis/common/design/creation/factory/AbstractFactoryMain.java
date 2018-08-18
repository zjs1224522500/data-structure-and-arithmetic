package me.elvis.common.design.creation.factory;

public class AbstractFactoryMain {

    public static void main(String[] args) {
        String to = "Elvis";
        String from  = "Shunzi";
        AbstractCommunicationFactory senderFactory = FactoryProducer.getFactory("Send");

        // sms sender
        CommonInterfaceSender smsSender = senderFactory.getSender(0);
        smsSender.sendMsg(to);

        // MailSender
        CommonInterfaceSender mailSender = senderFactory.getSender(1);
        smsSender.sendMsg(to);

        // WeChat Sender
        CommonInterfaceSender wechatSender = senderFactory.getSender(2);
        wechatSender.sendMsg(to);

        AbstractCommunicationFactory receiverFactory = FactoryProducer.getFactory("Receive");

        // sms receiver
        CommonInterfaceReceiver smsReceiver = receiverFactory.getReceiver(0);
        smsReceiver.receiveMsg(from);

        CommonInterfaceReceiver mailReceiver = receiverFactory.getReceiver(1);
        mailReceiver.receiveMsg(from);

        CommonInterfaceReceiver wechatReceiver = receiverFactory.getReceiver(2);
        wechatReceiver.receiveMsg(from);

    }
}
