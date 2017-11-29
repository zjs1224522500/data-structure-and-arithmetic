package me.elvis.common.design.creation.singleton;

/**
 * Version:v1.0 (description:采用双锁机制，安全且在多线程情况下能保持高性能。  )
 * Date:2017/11/29 0029  Time:20:27
 */
public class DCLSingleton {

	/**
	 * 使用volatile关键字:
	 * 在访问volatile变量时不会执行加锁操作，因此也就不会使执行线程阻塞，
	 * 因此volatile变量是一种比sychronized关键字更轻量级的同步机制。
	 */
	private volatile static DCLSingleton singleton;

	private DCLSingleton(){}

	public static DCLSingleton getInstance() {
		if(null == singleton) {

			// 加锁2
			synchronized (DCLSingleton.class) {
				if(null == singleton) {
					singleton = new DCLSingleton();
				}
			}
		}

		return singleton;
	}

}
