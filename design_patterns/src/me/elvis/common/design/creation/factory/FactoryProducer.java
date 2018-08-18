package me.elvis.common.design.creation.factory;

public class FactoryProducer {

    public static AbstractCommunicationFactory getFactory(String direction) {
        if ("Send".equals(direction)) {
            return new SenderFactory();
        } else if ("Receive".equals(direction)) {
            return new ReceiverFactory();
        }
        return null;
    }
}
