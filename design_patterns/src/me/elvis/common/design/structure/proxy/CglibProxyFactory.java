<<<<<<< Updated upstream
//
//package me.elvis.common.design.structure.proxy;
//
//import net.sf.cglib.proxy.Enhancer;
//import net.sf.cglib.proxy.MethodInterceptor;
//import net.sf.cglib.proxy.MethodProxy;
//
//import java.lang.reflect.Method;
//
///**
// * Version:v1.0 (description:目标对象没有实现任何接口  )
// * Cglib子类代理工厂，对目标对象在内存中动态创建一个子类对象。利用对应的AVM修改字节码
// * Date:2017/12/1 0001  Time:11:49
// */
//public class CglibProxyFactory implements MethodInterceptor {
//
//	private Object target;
//
//	public CglibProxyFactory(Object target) {
//		this.target = target;
//	}
//
//	public Object getProxyInstance() {
//		Enhancer enhancer = new Enhancer();
//		enhancer.setSuperclass(target.getClass());
//		enhancer.setCallback(this);
//		return enhancer.create();
//	}
//
//	@Override
//	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
//			throws Throwable {
//		System.out.println("开始事务...");
//
//		Object returnValue = method.invoke(target, objects);
//
//		System.out.println("提交事务...");
//		return returnValue;
//	}
//
//	public static void main(String[] args) {
//		UserDao target = new UserDao();
//		UserDao proxy = (UserDao) new CglibProxyFactory(target).getProxyInstance();
//		proxy.save();
//	}
//}
=======

package me.elvis.common.design.structure.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Version:v1.0 (description:目标对象没有实现任何接口  )
 * Cglib子类代理工厂，对目标对象在内存中动态创建一个子类对象。利用对应的AVM修改字节码
 * Date:2017/12/1 0001  Time:11:49
 */
public class CglibProxyFactory implements MethodInterceptor {

	private Object target;

	public CglibProxyFactory(Object target) {
		this.target = target;
	}

	public Object getProxyInstance() {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(target.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}


	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
			throws Throwable {
		System.out.println("开始事务...");

		Object returnValue = method.invoke(target, objects);

		System.out.println("提交事务...");
		return returnValue;
	}

	public static void main(String[] args) {
		UserDao target = new UserDao();
		UserDao proxy = (UserDao) new CglibProxyFactory(target).getProxyInstance();
		proxy.save();
	}
}
>>>>>>> Stashed changes
