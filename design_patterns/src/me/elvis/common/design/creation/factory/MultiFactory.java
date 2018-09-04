package me.elvis.common.design.creation.factory;

/**
 * Version:v1.0 (description: 对工厂模式的改进 )
 * 定义多实例工厂，通过调用不同的方法返回不同的实例。但这些实例返回值均为公共接口。
 *
 * Date:2017/11/29 0029  Time:19:01
 */
public class MultiFactory {

<<<<<<< Updated upstream
	public CommonInterfaceSender sendByMail() {
=======

	public CommonInterfaceSender produceMail() {
>>>>>>> Stashed changes
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
