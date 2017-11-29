package me.elvis.common.design.creation.singleton;

/**
 * Version:v1.0 (description: 饿汉式单例模式  )
 * 类一旦加载，就把单例初始化完成，保证getInstance的时候，单例是已经存在的了
 * 借用JVM内部关于类加载时的线程互斥的机制保证了饿汉式的天生线程安全
 * Date:2017/11/29
 * 0029  Time:19:56
 */
public class SimpleSingletonTwo {

	private static final SimpleSingletonTwo instance = new SimpleSingletonTwo();

	public SimpleSingletonTwo() {
	}

	public static SimpleSingletonTwo getInstance() {
		return instance;
	}
}
