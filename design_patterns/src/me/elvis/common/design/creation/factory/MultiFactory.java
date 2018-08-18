package me.elvis.common.design.creation.factory;

/**
 * Version:v1.0 (description:  ) Date:2017/11/29 0029  Time:19:01
 */
public class MultiFactory {

	public CommonInterfaceSender sendByMail() {
		return new MailSender();
	}

	public CommonInterfaceSender SendByMsg() {
		return new SmsSender();
	}

	public static void main(String[] args){
		// 需要实例化工厂，可以将获取对应的实例的方法设置为静态static
	    MultiFactory factory = new MultiFactory();
	    CommonInterfaceSender sender = factory.sendByMail();
	    sender.sendMsg("");
	}
}
