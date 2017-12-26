package me.elvis.collection;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.RandomAccess;

import me.elvis.test.TestEfficiency;

/**
 * Version:v1.0 (description:  ) Date:2017/12/26 0026  Time:14:42
 */
public class Ergodic<E> {

	private static Ergodic instance = null;

	private Ergodic() {
	}

	public static Ergodic<String> getInstance() {
		if (null == instance) {
			instance = new Ergodic<String>();
		}
		return instance;
	}

	public void printAllUsingForEach(List<E> list) {
		for (E e : list) {
			System.out.print(e);
		}
		System.out.println();
	}

	public void printAllUsingFor(List<E> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
		}
		System.out.println();
	}

	public void printAllUsingIterator(List<E> list) {
		for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
			E e = (E) iterator.next();
			System.out.print(e);
		}
		System.out.println();
	}

	/**
	 * 判断list是否支持随机访问，支持则使用for循环遍历，不支持则使用迭代器
	 * @param list
	 */
	public void printAll(List<E> list) {
		if(list instanceof RandomAccess) {
			printAllUsingFor(list);
		} else {
			printAllUsingIterator(list);
		}
	}

	public static void main(String[] args) {
		List<String> orderList = new ArrayList<String>() {{
			add("张三");
			add("李四");
			add("王五");
		}};

		List<String> randomList = new LinkedList<String>() {{
			add("张三");
			add("李四");
			add("王五");
		}};

		Ergodic<String> ergodic = getInstance();
		//		ergodic.printAllUsingFor(orderList);
		//		ergodic.printAllUsingFor(randomList);
		//		ergodic.printAllUsingForEach(orderList);
		//		ergodic.printAllUsingForEach(randomList);
		//		ergodic.printAllUsingIterator(orderList);
		//		ergodic.printAllUsingIterator(randomList)
//
//		System.out.println("顺序结构-For：" + getListErgodicRunningTime("printAllUsingFor", orderList));
//		System.out.println("链式结构-For：" + getListErgodicRunningTime("printAllUsingFor", randomList));
//
//		System.out.println("顺序结构-ForEach：" + getListErgodicRunningTime("printAllUsingForEach",orderList));
//		System.out.println("链式结构-ForEach：" + getListErgodicRunningTime("printAllUsingForEach",randomList));
//
//		System.out.println("顺序结构-迭代器：" + getListErgodicRunningTime("printAllUsingIterator",orderList));
//		System.out.println("链式结构-迭代器：" + getListErgodicRunningTime("printAllUsingIterator",randomList));
//
		ergodic.printAll(orderList);
		ergodic.printAll(randomList);
	}

	public static String getListErgodicRunningTime(String methodName, Object param) {
		String str = null;
		try {
			str = TestEfficiency.getRunTimeResults(getInstance(),
					Ergodic.class.getMethod(methodName, List.class), param);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return str;
	}

}
