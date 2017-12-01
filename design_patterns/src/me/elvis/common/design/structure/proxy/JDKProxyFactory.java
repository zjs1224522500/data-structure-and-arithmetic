package me.elvis.common.design.structure.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Version:v1.0 创建动态代理对象的时候需要指定对应的接口
 * (description: 代理对象不需要实现接口，但目标对象需要实现相应的接口  )
 * Date:2017/12/1 0001  Time:11:39
 */
public class JDKProxyFactory {

	private Object target;

	public JDKProxyFactory(Object target) {
		this.target = target;
	}

	public Object getProxyInstance() {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						System.out.println("开始事务....");
						Object returnValue = method.invoke(target, args);
						System.out.println("提交事务....");
						return returnValue;
					}
				});
	}

	public static void main(String[] args) {
		//创建目标对象
		IUserDao target = new UserDao();
		System.out.println(target.getClass());

		//为目标对象创建代理对象，但需要指定接口类型
		IUserDao proxy = (IUserDao) new JDKProxyFactory(target).getProxyInstance();
		System.out.println(proxy.getClass());


		proxy.save();
	}
}
