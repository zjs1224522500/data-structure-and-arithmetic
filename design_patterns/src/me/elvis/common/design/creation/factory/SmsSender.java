package me.elvis.common.design.creation.factory;

/**
 * Version:v1.0 (description:  ) Date:2017/11/29 0029  Time:18:55
 */
public class SmsSender implements CommonInterfaceSender {

	@Override
	public void send() {
		System.out.println("Sms send!");
	}
}
