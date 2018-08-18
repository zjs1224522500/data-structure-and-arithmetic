package me.elvis.common.design.creation.factory;

import org.junit.Test;

/**
 * Version:v1.0 (description:  ) Date:2017/11/29 0029  Time:19:12
 */
public class IMsgFactoryTest {

	@Test
	public void test() {
		IMsgFactory IMsgFactory = new SendMailFactory();
		CommonInterfaceSender sender = IMsgFactory.createSender();
		sender.sendMsg("");
	}
}
