package me.elvis.common.design.creation.singleton;

/**
 * Version:v1.0 (description: 加锁避免多线程同时请求的问题  ) Date:2017/11/29 0029  Time:19:39
 */
public class SafeSimpleSingleton {

	/**
	 * 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载
	 */
	private static SafeSimpleSingleton instance = null;

	/**
	 * 私有构造方法，防止被实例化
	 */
	private SafeSimpleSingleton() {
	}

	/**
	 * 获取唯一的实例 synchronized关键字锁住的是这个对象， 这样的用法，在性能上会有所下降，因为每次调用getInstance()，都要对对象上锁，
	 * 事实上，只有在第一次创建对象的时候需要加锁，之后就不需要了
	 * 改进：getInstanceTwo
	 *
	 * @return
	 */
	public static synchronized SafeSimpleSingleton getInstanceOne() {
		if (null == instance) {
			instance = new SafeSimpleSingleton();
		}
		return instance;
	}

	/**
	 * 只有在instance为null，并创建对象的时候才需要加锁，性能有一定的提升。
	 *
	 * @return
	 */
	public static SafeSimpleSingleton getInstanceTwo() {
		if (instance == null) {
			synchronized (instance) {
				if (instance == null) {
					instance = new SafeSimpleSingleton();
				}
			}
		}
		return instance;
	}

	/**
	 * 如果该对象被用于序列化，可以保证对象在序列化前后保持一致
	 *
	 * @return
	 */
	public Object readResolve() {
		return instance;
	}

}
