package me.elvis.common.design.creation.factory;

/**
 * Version:v1.0 (description:  ) Date:2017/11/29 0029  Time:19:04
 */
public class StaticMultiFactory {

	public static CommonInterfaceSender produceMail() {
		return new MailSender();
	}

	public static CommonInterfaceSender produceSms() {
		return new SmsSender();
	}

	public static void main(String[] args){
	    CommonInterfaceSender sender = StaticMultiFactory.produceMail();
	    sender.send();
	}
}
