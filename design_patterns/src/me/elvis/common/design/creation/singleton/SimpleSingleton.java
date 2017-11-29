package me.elvis.common.design.creation.singleton;

/**
 * Version:v1.0 (description:单例对象能保证在一个JVM中，该对象只有一个实例存在  )
 * Type：懒汉式
 * Date:2017/11/29 0029  Time:19:34
 * 1、某些类创建比较频繁，对于一些大型的对象，这是一笔很大的系统开销。
 * 2、省去了new操作符，降低了系统内存的使用频率，减轻GC压力。
 * 3、有些类如交易所的核心交易引擎，控制着交易流程，如果该类可以创建多个的话，系统完全乱了 所以只有使用单例模式，才能保证核心交易服务器独立控制整个流程。
 */
public class SimpleSingleton {

	/**
	 * 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载
	 */
	private static SimpleSingleton instance = null;

	/**
	 * 私有构造方法，防止被实例化
	 */
	private SimpleSingleton() {
	}

	/**
	 * 获取唯一的实例
	 *
	 * @return
	 */
	public static SimpleSingleton getInstance() {
		if (null == instance) {
			instance = new SimpleSingleton();
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
