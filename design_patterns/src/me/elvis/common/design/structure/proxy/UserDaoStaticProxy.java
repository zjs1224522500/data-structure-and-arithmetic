package me.elvis.common.design.structure.proxy;

/**
 * Version:v1.0
 * (description: 代理对象需要与目标对象实现一样的接口,所以会有很多代理类,
 * 类太多.同时,一旦接口增加方法,目标对象与代理对象都要维护. )
 * Date:2017/12/1 0001  Time:11:32
 */
public class UserDaoStaticProxy implements IUserDao {

	//依赖目标对象
	private IUserDao target;

	public UserDaoStaticProxy(IUserDao target) {
		this.target = target;
	}

	public void save() {
		System.out.println("开始事务...");
		target.save();//执行目标对象的方法
		System.out.println("提交事务...");
	}

	public static void main(String[] args){
	    UserDao target = new UserDao();
		UserDaoStaticProxy userDaoProxy = new UserDaoStaticProxy(target);
		userDaoProxy.save();
	}
}
