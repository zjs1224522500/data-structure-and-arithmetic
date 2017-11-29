package me.elvis.common.design.creation.singleton;

/**
 * Version:v1.0 (description: 相比饿汉式实现懒加载)
 * 这种方式能达到双检锁方式一样的功效，但实现更简单。
 * 对静态域使用延迟初始化，应使用这种方式而不是双检锁方式。
 * 这种方式只适用于静态域的情况，双检锁方式可在实例域需要延迟初始化时使用。
 *
 * 这种方式同样利用了 classloder 机制来保证初始化 instance 时只有一个线程
 * Date:2017/11/29 0029  Time:20:31
 */
public class BetterSingletonTwo {

	private static class SingletonTwoHolder {

		private static final BetterSingletonTwo INSTANCE = new BetterSingletonTwo();
	}

	private BetterSingletonTwo() {
	}

	private static final BetterSingletonTwo getInstance() {
		return SingletonTwoHolder.INSTANCE;
	}

}
