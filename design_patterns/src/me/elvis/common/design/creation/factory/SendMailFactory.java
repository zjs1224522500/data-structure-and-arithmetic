package me.elvis.common.design.creation.factory;

/**
 * Version:v1.0 (description: 继承抽象工厂接口，创建对应的工厂类  )
 * Date:2017/11/29 0029  Time:19:08
 */
public class SendMailFactory implements IMsgFactory {

	@Override
	public CommonInterfaceSender createSender() {
		return new MailSender();
	}
}
