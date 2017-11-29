package me.elvis.common.design.creation.factory;

/**
 * Version:v1.0 (description:  )
 * 建立一个工厂类，对实现了同一接口的一些类进行实例的创建
 * Date:2017/11/29 0029  Time:18:53
 */
public class OrdinaryFactory {


	//如果传递的字符串出错，则不能正确创建对象
	// 改进：多个工厂方法模式
	public CommonInterfaceSender produce(String type) {
		if ("mail".equals(type)) {
			return new MailSender();
		} else if ("sms".equals(type)) {
			return new SmsSender();
		} else {
			System.out.println("Please check the type!");
			return null;
		}
	}

	public static void main(String[] args) {
		OrdinaryFactory ordinaryFactory = new OrdinaryFactory();
		CommonInterfaceSender sender = ordinaryFactory.produce("sms");
		sender.send();
	}
}
