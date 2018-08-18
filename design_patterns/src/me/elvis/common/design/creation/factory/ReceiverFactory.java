package me.elvis.common.design.creation.factory;

public class ReceiverFactory extends AbstractCommunicationFactory {
    @Override
    public CommonInterfaceSender getSender(int typeNum) {
        return null;
    }

    @Override
    public CommonInterfaceReceiver getReceiver(int typeNum) {
        switch (typeNum) {
            case 0:
                return new SmsReceiver();
            case 1:
                return new MailReceiver();
            case 2:
                return new WechatReceiver();
            default:
                return null;
        }
    }
}
