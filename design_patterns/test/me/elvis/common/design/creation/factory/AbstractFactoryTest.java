package me.elvis.common.design.creation.factory;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Version:v1.0 (description:  ) Date:2017/11/29 0029  Time:19:12
 */
public class AbstractFactoryTest {

	@Test
	public void test() {
		AbstractFactory abstractFactory = new SendMailFactory();
		CommonInterfaceSender sender = abstractFactory.produce();
		sender.send();
	}
}
