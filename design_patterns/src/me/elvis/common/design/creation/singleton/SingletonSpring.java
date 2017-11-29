package me.elvis.common.design.creation.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * Version:v1.0 (description: 登记式单例 )
 * 维护了一组单例类的实例，将这些实例存放在一个Map（登记薄）中，
 * 对于已经登记过的实例，则从Map直接返回，对于没有登记的，则先登记，然后返回。
 *
 * 其实内部实现还是用的饿汉式单例，
 * 因为其中的static方法块，它的单例在类被装载的时候就被实例化了。
 * Date:2017/11/29 0029  Time:20:11
 */
public class SingletonSpring {

	private static Map<String, SingletonSpring> map = new HashMap<String, SingletonSpring>();

	static {
		SingletonSpring singletonSpring = new SingletonSpring();
		map.put(singletonSpring.getClass().getName(), singletonSpring);
	}

	protected SingletonSpring() {
	}

	public static SingletonSpring getInstance(String name) {
		if (name == null) {
			name = SingletonSpring.class.getName();
			System.out.println("name == null" + "--->name=" + name);
		}

		if (map.get(name) == null) {
			try {
				map.put(name, (SingletonSpring) Class.forName(name).newInstance());
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return map.get(name);
	}

	public void say() {
		System.out.println("singletonSpring is running!");
	}

	public static void main(String[] args){
	    SingletonSpring singletonSpring = SingletonSpring.getInstance(null);
	    singletonSpring.say();
	}
}
