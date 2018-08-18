package me.elvis.common.design.creation.factory;

public class SenderFactory extends AbstractCommunicationFactory {

    @Override
    public CommonInterfaceSender getSender(int typeNum) {
        switch (typeNum) {
            case 0:
                return new SmsSender();
            case 1:
                return new MailSender();
            case 2:
                return new WechatSender();
            default:
                return null;
        }
    }

    @Override
    public CommonInterfaceReceiver getReceiver(int typeNum) {
        return null;
    }
}
