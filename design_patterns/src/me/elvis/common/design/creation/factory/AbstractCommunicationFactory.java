package me.elvis.common.design.creation.factory;

public abstract class AbstractCommunicationFactory {

    public abstract CommonInterfaceSender getSender(int typeNum);
    public abstract CommonInterfaceReceiver getReceiver(int typeNum);
}
