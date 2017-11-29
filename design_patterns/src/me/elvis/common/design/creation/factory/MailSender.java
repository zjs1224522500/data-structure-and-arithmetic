package me.elvis.common.design.creation.factory;

/**
 * Version:v1.0 (description:  ) Date:2017/11/29 0029  Time:18:55
 */
public class MailSender implements CommonInterfaceSender {

	@Override
	public void send() {
		System.out.println("send Mail!");
	}
}
