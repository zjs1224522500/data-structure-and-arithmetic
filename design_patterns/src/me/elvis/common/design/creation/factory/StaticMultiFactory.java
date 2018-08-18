package me.elvis.common.design.creation.factory;

/**
 * Version:v1.0 (description:  ) Date:2017/11/29 0029  Time:19:04
 */
public class StaticMultiFactory {

	public static CommonInterfaceSender sendByMail() {
		return new MailSender();
	}

	public static CommonInterfaceSender sendByMessage() {
		return new SmsSender();
	}

	public static void main(String[] args){
	    CommonInterfaceSender sender = StaticMultiFactory.sendByMail();
	    sender.sendMsg("");
	}
}
